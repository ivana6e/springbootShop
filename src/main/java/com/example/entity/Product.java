package com.example.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product") // mongoDB
public class Product {
	
	private String id;
    private String name;
    private int price;
    private int stock;
    private String imgUrl;
    private ProductCategory category;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    public String getImgUrl() {
        return imgUrl;
    }
    
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    
    public ProductCategory getCategory() {
        return category;
    }
    
}
