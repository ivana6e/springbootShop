package com.example.service;

import com.example.converter.ProductConverter;
import com.example.entity.Product;
import com.example.entity.ProductRequest;
import com.example.entity.ProductResponse;
import com.example.exception.*;
import com.example.parameter.ProductParameter;
import com.example.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	// create product
    public ProductResponse createProduct(ProductRequest request) {
        Product product = ProductConverter.toProduct(request);
        product = productRepository.insert(product);
        return ProductConverter.toProductResponse(product);
    }
    
    // read product
    public ProductResponse readProduct(String id) {
    	Product product = productRepository.findById(id)
                 .orElseThrow(() -> new NotFound("Can't find product."));
        return ProductConverter.toProductResponse(product);
    }
    
    // read all products
    public List<ProductResponse> readProducts(ProductParameter param) {
    	String keyword = Optional.ofNullable(param.getKeyword()).orElse("");
        int minPrice = param.getMinPrice();
        int maxPrice = param.getMaxPrice();
        
        if(maxPrice == 0) maxPrice = Integer.MAX_VALUE;
        
        // id, name, price: ASC, DESC
        Sort sort = genSortingStrategy(param.getOrderBy(), param.getSortRule());
        
        List<Product> products = productRepository.findByPriceBetweenAndNameLikeIgnoreCase(minPrice, maxPrice, keyword, sort);

        return products.stream()
                .map(ProductConverter::toProductResponse)
                .collect(Collectors.toList());
        
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
    public ProductResponse updateProduct(String id, ProductRequest request) {
    	Product oldProduct = productRepository.findById(id)
                 .orElseThrow(() -> new NotFound("Can't find product."));
        Product newProduct = ProductConverter.toProduct(request);
        newProduct.setId(oldProduct.getId());
        productRepository.save(newProduct);

        return ProductConverter.toProductResponse(newProduct);
    }

    // delete product
    public void deleteProduct(String id) {
    	productRepository.deleteById(id);
    }
    
}
