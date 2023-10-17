package com.pag.registropedido.Dto;
public class StockDTO {

    private long stockId;
    private long productId;
    private int quantity;
    

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantityAvalible() {
        return quantity;
    }

    public void setQuantityAvalible(int quantityAvalible) {
        this.quantity = quantityAvalible;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    

}
