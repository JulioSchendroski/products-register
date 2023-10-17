package com.pag.registropedido.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pag.registropedido.Controller.Request.OrderRequest;
import com.pag.registropedido.Controller.Response.OrderResponse;
import com.pag.registropedido.Domain.Entity.OrderEntity;
import com.pag.registropedido.Domain.Repository.OrderRepository;
import com.pag.registropedido.Mapper.OrderMapping;
import com.pag.registropedido.Service.OrderService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapping orderMapping;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest requestModel) {
        orderService.createOrder(requestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderMapping.toResponse(requestModel));
    }

    @GetMapping("/orders/status/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));
        
        return ResponseEntity.ok(orderMapping.toResponse(order));
    }
}
