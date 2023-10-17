package com.pag.registropedido.Domain.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pag.registropedido.Domain.Entity.ProductEntity;
import com.pag.registropedido.Domain.Entity.StockEntity;

@DataJpaTest
@DisplayName("Test for Product Repository")
public class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @Test
    @DisplayName("Test save stock")
    public void testSaveStock() {

        StockEntity stock = new StockEntity();
        ProductEntity product = new ProductEntity();
        stock.setProduct(product);
        stock.setQuantity(10);

        StockEntity savedStock = stockRepository.save(stock);

        Assertions.assertNotNull(savedStock.getStockId());
    }
}
