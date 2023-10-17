package com.pag.registropedido.Domain.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pag.registropedido.Domain.Entity.ProductEntity;

@DataJpaTest
@DisplayName("Test for Product Repository")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Test save product")
    public void testSaveProduct() {
        
        ProductEntity product = new ProductEntity();
        product.setName("Test Product");
        product.setPrice(9.99);

        ProductEntity savedProduct = productRepository.save(product);

        Assertions.assertNotNull(savedProduct.getId());
    }

    @Test
    @DisplayName("Test find product by id")
    public void testFindProductById() {

        ProductEntity product = new ProductEntity();
        product.setName("Test Product");
        product.setPrice(9.99);
        productRepository.save(product);

        ProductEntity foundProduct = productRepository.findById(product.getId()).orElse(null);

        Assertions.assertNotNull(foundProduct);
        Assertions.assertEquals(product.getName(), foundProduct.getName());
    }
}
