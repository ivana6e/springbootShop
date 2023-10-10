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
    
}
