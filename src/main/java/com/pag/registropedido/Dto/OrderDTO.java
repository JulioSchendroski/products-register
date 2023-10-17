package com.pag.registropedido.Dto;
import java.util.List;
import com.pag.registropedido.Controller.Models.ProductOrderCreateModel;

public class OrderDTO {
    private Long id;
    private List<ProductOrderCreateModel> products;
    private String status;
    
    public Long getOrderId() {
        return id;
    }
    public void setOrderId(Long id) {
        this.id = id;
    }
    public List<ProductOrderCreateModel> getProducts() {
        return products;
    }
    public void setProducts(List<ProductOrderCreateModel> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
 
   
}
