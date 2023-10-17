package com.pag.registropedido.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pag.registropedido.Domain.Entity.ProductEntity;
import com.pag.registropedido.Domain.Entity.StockEntity;
import com.pag.registropedido.Domain.Repository.StockRepository;
import com.pag.registropedido.Dto.ProductDTO;
import com.pag.registropedido.Dto.StockDTO;
import com.pag.registropedido.Mapper.ProductMapper;
import com.pag.registropedido.Mapper.StockMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProductMapper productMapper;
    @Autowired
    StockMapper stockMapper;
    

    @Transactional
    public ProductDTO createStock(ProductDTO productDto, int quantity) {
        ProductEntity productEntity = productMapper.toEntity(productDto);
    
        StockEntity stock = new StockEntity();
        stock.setProduct(productEntity);
        stock.setQuantity(quantity);
        StockEntity createdStock = stockRepository.save(stock);
    
        return productMapper.toDTO(createdStock.getProduct());
    }
    
    @Transactional
    public void deleteStock(StockEntity stock) {
        stockRepository.delete(stock);
    }
    
    @Transactional
    public boolean verifyProductAvailability(Long productId, int quantityRequest) {

        StockEntity stock = stockRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Produto nor found"));

            int quantityAvailable = stock.getQuantity();

            if (quantityAvailable > 0) {
                stock.setQuantity(quantityAvailable - quantityRequest );
            } else {
                throw new RuntimeException("Insufficient quantity of product");
            }

            if(stock.getQuantity() < 0){
                throw new RuntimeException("Insufficient quantity of product");
            }
        return true;
    }

    @Transactional
    public StockDTO updateProductQuantity(Long id, int newQuantity) {
        StockEntity stock = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found"));
    
        stock.setQuantity(newQuantity);
    
        StockEntity updatedStock = stockRepository.save(stock);
        return stockMapper.toDTO(updatedStock);
    }
        
    public StockDTO getStockById(long id){
        Optional<StockEntity> optionalStockEntity = stockRepository.findById(id);

        if (optionalStockEntity.isPresent()){
            StockEntity stockEntity = optionalStockEntity.get();
            return stockMapper.toDTO(stockEntity);

        }else {
            throw new EntityNotFoundException("Stock not found: " + id);
        }
    }

    @Transactional
    public void deleteStockById(long id) {
        Optional<StockEntity> optionalProduct = stockRepository.findById(id);
        
        if (optionalProduct.isPresent()) {
            StockEntity product = optionalProduct.get();
            stockRepository.delete(product);
        } else {
            throw new EntityNotFoundException("Stock not found: " + id);
        }
    }
}
