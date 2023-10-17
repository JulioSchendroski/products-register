package com.pag.registropedido.Domain.Entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductEntityTest {

    private ProductEntity product;

    @BeforeEach
    public void setUp() {
        product = new ProductEntity();
    }

    @Test
    @DisplayName("Test get and set id")
    public void testGetSetId() {
        Long id = 1L;
        product.setId(id);
        Assertions.assertEquals(id, product.getId());
    }

    @Test
    @DisplayName("Test get and set name")
    public void testGetSetName() {
        String name = "Product Name";
        product.setName(name);
        Assertions.assertEquals(name, product.getName());
    }

    @Test
    @DisplayName("Test get and set price")
    public void testGetSetPrice() {
        Double price = 9.99;
        product.setPrice(price);
        Assertions.assertEquals(price, product.getPrice());
    }

    @Test
    @DisplayName("Test get and set orders")
    public void testGetSetOrders() {
        List<OrderEntity> orders = new ArrayList<>();
        orders.add(new OrderEntity());
        product.setOrders(orders);
        Assertions.assertEquals(orders, product.getOrders());
    }
}
