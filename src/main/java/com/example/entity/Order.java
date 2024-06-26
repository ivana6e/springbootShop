package com.example.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product") // mongoDB
public class Order {
	
	private String orderId;
	private String userId;
    private int amount;
    private Date createDate;
    private Date modifyDate;
    private List<OrderItem> orderItemList;
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    
    public Date getModifyDate() {
        return modifyDate;
    }
    
    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
    
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

}
