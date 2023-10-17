package com.pag.registropedido.Domain.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pag.registropedido.Domain.Entity.OrderEntity;

@DataJpaTest
@DisplayName("Test for Order Repository")
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("Test save order")
    public void testSaveOrder() {
        
        OrderEntity order = new OrderEntity();
        order.setStatus("IN_PROCESS");

        OrderEntity savedOrder = orderRepository.save(order);

        Assertions.assertNotNull(savedOrder.getId());
    }

    @Test
    @DisplayName("Test find order by ID")
    public void testFindOrderById() {

        OrderEntity order = new OrderEntity();
        order.setStatus("IN_PROCESS");
        OrderEntity savedOrder = orderRepository.save(order);

        OrderEntity foundOrder = orderRepository.findById(savedOrder.getId()).orElse(null);

        Assertions.assertNotNull(foundOrder);
        Assertions.assertEquals(savedOrder.getId(), foundOrder.getId());
    }

    @Test
    @DisplayName("Test find non-existent order by ID")
    public void testFindNonExistentOrderById() {
        OrderEntity foundOrder = orderRepository.findById(999L).orElse(null);

        Assertions.assertNull(foundOrder);
    }

}
