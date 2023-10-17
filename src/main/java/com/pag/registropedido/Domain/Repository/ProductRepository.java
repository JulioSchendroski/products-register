package com.pag.registropedido.Domain.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.registropedido.Domain.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
}