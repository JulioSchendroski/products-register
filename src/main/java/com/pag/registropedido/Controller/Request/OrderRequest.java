package com.pag.registropedido.Controller.Request;
import java.util.List;
import com.pag.registropedido.Controller.Models.ProductOrderCreateModel;

public class OrderRequest {
    
    private Long orderId;
    private List<ProductOrderCreateModel> products;
    
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public List<ProductOrderCreateModel> getProducts() {
        return products;
    }
    public void setProducts(List<ProductOrderCreateModel> products) {
        this.products = products;
    }

    
}
