package com.example.parameter;

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
    
    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
    
}
