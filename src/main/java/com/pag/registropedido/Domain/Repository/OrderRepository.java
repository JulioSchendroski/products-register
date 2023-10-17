package com.pag.registropedido.Domain.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.registropedido.Domain.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    
}