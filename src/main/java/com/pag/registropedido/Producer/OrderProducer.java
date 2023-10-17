package com.pag.registropedido.Producer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.pag.registropedido.Domain.Entity.OrderEntity;

public class OrderProducer {
    
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderEntity order) {
        rabbitTemplate.convertAndSend("order-created", order);
    }
}
