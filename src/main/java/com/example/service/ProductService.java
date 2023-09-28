package com.example.service;

import com.example.entity.Product;
import com.example.exception.*;
import com.example.parameter.ProductParameter;
import com.example.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	// create product
    public Product createProduct(Product request) {
        Product product = new Product();
        product.setId(request.getId()); //
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return productRepository.insert(product);
    }
    
    // read product
    public Product readProduct(String id) {
    	return productRepository.findById(id)
                .orElseThrow(() -> new NotFound("No product."));
    }
    
    // read all products
    public List<Product> readProducts(ProductParameter param) {
    	String keyword = Optional.ofNullable(param.getKeyword()).orElse("");
        int minPrice = param.getMinPrice();
        int maxPrice = param.getMaxPrice();
        if(maxPrice == 0) maxPrice = Integer.MAX_VALUE;
        Sort sort = genSortingStrategy(param.getOrderBy(), param.getSortRule());
        return productRepository.findByPriceBetweenAndNameLikeIgnoreCase(minPrice, maxPrice, keyword, sort);
    }
    
    // sort
    private Sort genSortingStrategy(String orderBy, String sortRule) {
        Sort sort = Sort.unsorted();
        if (Objects.nonNull(orderBy) && Objects.nonNull(sortRule)) {
            Sort.Direction direction = Sort.Direction.fromString(sortRule);
            sort = Sort.by(direction, orderBy);
        }
        return sort;
    }

    // update product
    public Product updateProduct(String id, Product request) {
    	Product oldProduct = readProduct(id);
        Product product = new Product();
        product.setId(oldProduct.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }

    // delete product
    public void deleteProduct(String id) {
    	productRepository.deleteById(id);
    }
    
}
