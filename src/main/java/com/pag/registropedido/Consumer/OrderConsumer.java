package com.pag.registropedido.Consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pag.registropedido.Domain.Entity.OrderEntity;
import com.pag.registropedido.Domain.Repository.OrderRepository;
import com.pag.registropedido.Mapper.OrderMapping;
import com.pag.registropedido.Service.OrderService;

@Component
public class OrderConsumer {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapping orderMapping;

    @RabbitListener(queues = "order-created")
    public void listen(OrderEntity order) {
        orderService.updateOrderStatusToSuccess(order);
        orderRepository.save(order);
    }
}
