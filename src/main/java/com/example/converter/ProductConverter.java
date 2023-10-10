package com.example.converter;

import com.example.entity.Product;
import com.example.entity.ProductRequest;
import com.example.entity.ProductResponse;

public class ProductConverter {

	// product request to database document(product)
    public static Product toProduct(ProductRequest request) {
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return product;
    }
    
    // database document(product) to product response
    public static ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());

        return productResponse;
    }

}
