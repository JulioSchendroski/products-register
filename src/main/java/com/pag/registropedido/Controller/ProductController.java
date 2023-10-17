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
import com.pag.registropedido.Controller.Request.ProductRequest;
import com.pag.registropedido.Controller.Response.ProductResponse;
import com.pag.registropedido.Dto.ProductDTO;
import com.pag.registropedido.Mapper.ProductMapper;
import com.pag.registropedido.Service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductController {
    

    @Autowired
    ProductService productService;
    
    @Autowired
    ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        ProductDTO productDto = productMapper.toDTO(productRequest);

        productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toReponse(productRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") long id) {
        ProductDTO productDTO = productService.getProductById(id);
    
        if (productDTO != null) {
            ProductResponse productResponse = productMapper.toReponse(productDTO);
            return ResponseEntity.status(HttpStatus.OK).body(productResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") long id, @RequestBody ProductRequest productRequest) {
        ProductDTO productDto = productMapper.toDTO(productRequest);
        
        productDto.setId(id);
        ProductDTO produtoAtualizado = productService.updateProduct(productDto);
        return ResponseEntity.ok().body(productMapper.toReponse(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        try {
            productService.deleteProductById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

