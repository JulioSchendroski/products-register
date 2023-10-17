package com.pag.registropedido.Domain.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pag.registropedido.Domain.Entity.StockEntity;
public interface StockRepository extends JpaRepository<StockEntity, Long> {
    
}