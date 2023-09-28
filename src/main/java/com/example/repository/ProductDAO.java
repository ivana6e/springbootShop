package com.example.repository;

import com.example.entity.Product;
import com.example.parameter.ProductParameter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	private final List<Product> productDB = new ArrayList<>();

    @PostConstruct
    private void initDB() {
    	productDB.add(new Product("R001", "Arles", 1888));
        productDB.add(new Product("R002", "Paradise", 1796));
        productDB.add(new Product("R003", "Samsara Room", 1935));
        productDB.add(new Product("R004", "Roots", 1859));
        productDB.add(new Product("R005", "Hotel", 1893));
    }

    public Product create(Product product) {
        productDB.add(product);
        return product;
    }

    public Product update(String id, Product product) {
        Optional<Product> productOp = find(id);
        productOp.ifPresent(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
        });

        return product;
    }

    public void delete(String id) {
        productDB.removeIf(p -> p.getId().equals(id));
    }

    public Optional<Product> find(String id) {
        return productDB.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Product> find(ProductParameter param) {
        String keyword = Optional.ofNullable(param.getKeyword()).orElse("");
        String orderBy = param.getOrderBy();
        String sortRule = param.getSortRule();
        Comparator<Product> comparator = genSortComparator(orderBy, sortRule);

        return productDB.stream()
                .filter(p -> p.getName().contains(keyword))
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private Comparator<Product> genSortComparator(String orderBy, String sortRule) {
        Comparator<Product> comparator = (p1, p2) -> 0;
        if (Objects.isNull(orderBy) || Objects.isNull(sortRule)) {
            return comparator;
        }

        if (orderBy.equalsIgnoreCase("price")) {
            comparator = Comparator.comparing(Product::getPrice);
        }
        else if (orderBy.equalsIgnoreCase("name")) {
            comparator = Comparator.comparing(Product::getName);
        }

        return sortRule.equalsIgnoreCase("desc")
                ? comparator.reversed()
                : comparator;
    }
    
}
