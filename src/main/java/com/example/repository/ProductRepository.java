package com.example.repository;

import com.example.entity.Product;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	@Query("{'$and': [{'price': {'$gte': ?0, '$lte': ?1}}, {'name': {'$regex': ?2, '$options': 'i'}}]}")
	List<Product> findByPriceBetweenAndNameLikeIgnoreCase(int priceFrom, int priceTo, String keyword, Sort sort);
	
}
