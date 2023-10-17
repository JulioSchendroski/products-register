package com.pag.registropedido.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pag.registropedido.Controller.Request.StockRequest;
import com.pag.registropedido.Controller.Response.StockResponse;
import com.pag.registropedido.Dto.ProductDTO;
import com.pag.registropedido.Dto.StockDTO;
import com.pag.registropedido.Mapper.StockMapper;
import com.pag.registropedido.Service.ProductService;
import com.pag.registropedido.Service.StockService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("stock")
public class StockController {
    
    @Autowired
    StockService stockService;
    
    @Autowired
    StockMapper stockMapper;
    
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<StockResponse> create(@RequestBody StockRequest stockRequest) {
        ProductDTO product = productService.getProductById(stockRequest.getProductId());
        if(product != null){
            stockService.createStock(product, stockRequest.getQuantity());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(stockMapper.toResponse(product));
    }

    @PutMapping("/{id}/quantity")
    public ResponseEntity<StockResponse> updateProductQuantity(@PathVariable("id") Long id, @RequestBody StockRequest stockRequest) {
        int newQuantity = stockRequest.getQuantity();
        if(newQuantity != 0){
            StockDTO updatedStock = stockService.updateProductQuantity(id, newQuantity);
            return ResponseEntity.status(HttpStatus.OK).body(stockMapper.toResponse(updatedStock));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponse> findById(@PathVariable("id") long id) {
        StockDTO stockDto = stockService.getStockById(id);
    
        if (stockDto != null) {
            StockResponse stockResponse = stockMapper.toResponse(stockDto);
            return ResponseEntity.status(HttpStatus.OK).body(stockResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        try {
            stockService.deleteStockById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}