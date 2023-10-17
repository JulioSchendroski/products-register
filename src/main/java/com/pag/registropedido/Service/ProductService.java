package com.pag.registropedido.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pag.registropedido.Domain.Entity.ProductEntity;
import com.pag.registropedido.Domain.Repository.ProductRepository;
import com.pag.registropedido.Dto.ProductDTO;
import com.pag.registropedido.Mapper.ProductMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Transactional
    public ProductEntity createProduct(ProductDTO product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        return productRepository.save(productEntity);
    }

    public ProductDTO getProductById(long id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        
        if (optionalProductEntity.isPresent()) {
            ProductEntity productEntity = optionalProductEntity.get();
            return productMapper.toDTO(productEntity);
        } else {
            throw new EntityNotFoundException("Product not found: " + id);
        }
    }

    @Transactional
    public void deleteProductById(long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            productRepository.delete(product);
        } else {
            throw new EntityNotFoundException("Product not found: " + id);
        }
    }

    @Transactional
    public ProductDTO updateProduct(ProductDTO product) {
        Optional<ProductEntity> productEntity = productRepository.findById(product.getId());
    
        if (productEntity.isPresent()) {
            ProductEntity existingProduct = productEntity.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productRepository.save(existingProduct);
            return productMapper.toDTO(existingProduct);
        } else {
            throw new EntityNotFoundException("Product not found: " + product.getId());
        }
    }
}