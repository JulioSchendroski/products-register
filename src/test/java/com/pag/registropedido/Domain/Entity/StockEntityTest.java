package com.pag.registropedido.Domain.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StockEntityTest {

    private StockEntity stock;

    @BeforeEach
    public void setUp() {
        stock = new StockEntity();
    }

    @Test
    @DisplayName("Test get and set id")
    public void testGetSetId() {
        Long id = 1L;
        stock.setStockId(id);
        Assertions.assertEquals(id, stock.getStockId());
    }

    @Test
    @DisplayName("Test get and set product")
    public void testGetSetProduct() {
        ProductEntity product = new ProductEntity();
        stock.setProduct(product);
        Assertions.assertEquals(product, stock.getProduct());
    }

    @Test
    @DisplayName("Test get and set quantity")
    public void testGetSetQuantity() {
        int quantity = 10;
        stock.setQuantity(quantity);
        Assertions.assertEquals(quantity, stock.getQuantity());
    }
}
