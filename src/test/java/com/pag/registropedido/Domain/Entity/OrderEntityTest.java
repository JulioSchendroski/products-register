package com.pag.registropedido.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderEntityTest {

    private OrderEntity order;

    @BeforeEach
    public void setUp() {
        order = new OrderEntity();
    }

    @Test
    @DisplayName("Test get and set id")
    public void testGetSetId() {
        Long id = 1L;
        order.setId(id);
        Assertions.assertEquals(id, order.getId());
    }

    @Test
    @DisplayName("Test get and set products")
    public void testGetSetProducts() {
        List<ProductEntity> products = new ArrayList<>();
        products.add(new ProductEntity());
        order.setProducts(products);
        Assertions.assertEquals(products, order.getProducts());
    }

    @Test
    @DisplayName("Test get and set status")
    public void testGetSetStatus() {
        String status = "Pending";
        order.setStatus(status);
        Assertions.assertEquals(status, order.getStatus());
    }
}
