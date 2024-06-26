package com.example.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product") // mongoDB
public class OrderItem {
	
	private String orderId;
	private String productId;
    private int quantity;
    private int sum;
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setSum(int sum) {
        this.sum = sum;
    }
    
    public int getSum() {
        return sum;
    }

}
