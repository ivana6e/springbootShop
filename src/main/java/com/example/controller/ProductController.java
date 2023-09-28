package com.example.controller;

import com.example.entity.Product;
import com.example.parameter.ProductParameter;
import com.example.service.ProductService;

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
    public ResponseEntity<Product> createProduct(@RequestBody Product request) {
		Product product = productService.createProduct(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(location).body(product);
    }
	
	// read product
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> readProduct(@PathVariable("id") String id){
		Product product = productService.readProduct(id);
	    return ResponseEntity.ok().body(product);
	}
	
	// read all products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> readProducts(@ModelAttribute ProductParameter param) {
		List<Product> products = productService.readProducts(param);
	    return ResponseEntity.ok(products);
	}
	
	// update product
	@PutMapping("products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product request) {
		Product product = productService.updateProduct(id, request);
        return ResponseEntity.ok().body(product);
	}
	
	// delete product
	@DeleteMapping("products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
		productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
	}
	
}
