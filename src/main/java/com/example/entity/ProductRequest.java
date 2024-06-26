package com.example.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequest {
	
	@NotBlank
	private String id;
	@NotBlank
    private String name;
	@Min(value = 0, message = "Price should be greater or equal to 0.")
    private int price;
	@Min(value = 0, message = "Stock should be greater or equal to 0.")
	private int stock;
	@NotBlank
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
