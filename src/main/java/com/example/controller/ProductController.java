package com.example.controller;

import com.example.entity.ProductRequest;
import com.example.entity.ProductResponse;
import com.example.parameter.ProductParameter;
import com.example.service.ProductService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
	// create product
	@PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
		ProductResponse productResponse = productService.createProduct(request);
		
        URI location = ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{id}")
        		.buildAndExpand(productResponse.getId())
        		.toUri();
        
        return ResponseEntity.created(location).body(productResponse);
    }
	
	// read product
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductResponse> readProduct(@PathVariable("id") String id){
		ProductResponse productResponse = productService.readProduct(id);
	    return ResponseEntity.ok(productResponse);
	}
	
	// read all products
	@GetMapping("/products")
	public ResponseEntity<List<ProductResponse>> readProducts(@ModelAttribute ProductParameter param) {
		List<ProductResponse> productResponses = productService.readProducts(param);
	    return ResponseEntity.ok(productResponses);
	}
	
	// update product
	@PutMapping("/products/{id}")
	public ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") String id, @Valid @RequestBody ProductRequest request) {
		ProductResponse productResponse = productService.updateProduct(id, request);
        return ResponseEntity.ok().body(productResponse);
	}
	
	// delete product
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
		productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
	}
	
}
