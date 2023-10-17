package com.pag.registropedido.Service;
import java.util.List;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pag.registropedido.Controller.Models.ProductOrderCreateModel;
import com.pag.registropedido.Controller.Request.OrderRequest;
import com.pag.registropedido.Domain.Entity.OrderEntity;
import com.pag.registropedido.Domain.Repository.OrderRepository;
import com.pag.registropedido.Dto.OrderDTO;
import com.pag.registropedido.Mapper.OrderMapping;
import com.pag.registropedido.Mapper.ProductMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    StockService stockService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    OrderMapping orderMapping;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Transactional
    public OrderDTO createOrder(OrderRequest requestModel) {
        OrderEntity order = new OrderEntity();
        List<ProductOrderCreateModel> products = requestModel.getProducts();
        
        for (ProductOrderCreateModel product : products) {
            Long productId = product.getProductId();
            int quantity = product.getQuantity();
            
            stockService.verifyProductAvailability(productId, quantity);
        }
        updateOrderStatusToProgess(order);
        rabbitTemplate.convertAndSend("order-created", order);
        return orderMapping.toDTO(order);
    }

    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));
    }

    public void updateOrderStatusToProgess(OrderEntity order) {
        order.setStatus("IN_PROGRESS");
    }

    public void updateOrderStatusToSuccess(OrderEntity order) {
        order.setStatus("SUCCESS");
    }
}
