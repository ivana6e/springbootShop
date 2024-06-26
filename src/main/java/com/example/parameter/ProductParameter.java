package com.example.parameter;

// encapsulate query string
public class ProductParameter {
	private String keyword;
    private String orderBy;
    private String sortRule;
    private int minPrice;
    private int maxPrice;
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public String getKeyword() {
        return keyword;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    
    public String getOrderBy() {
        return orderBy;
    }
    
    public void setSortRule(String sortRule) {
        this.sortRule = sortRule;
    }

    public String getSortRule() {
        return sortRule;
    }
    
    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }
    
    public int getMinPrice() {
        return minPrice;
    }
    
    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
    
}
