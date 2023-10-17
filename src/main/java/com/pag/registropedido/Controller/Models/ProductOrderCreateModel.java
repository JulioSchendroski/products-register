package com.pag.registropedido.Controller.Models;

public class ProductOrderCreateModel {
    private Long productId;
    private String name;
    private int quantity;

    
    
    public ProductOrderCreateModel(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
