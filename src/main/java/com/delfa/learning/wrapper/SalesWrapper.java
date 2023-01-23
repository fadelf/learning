package com.delfa.learning.wrapper;

public class SalesWrapper {
    private Double cheapestPrice;
    private Double mostExpensivePrice;
    private Double totalSales;
    private Double averagePrice;
    private Long totalBookSold;

    public Double getCheapestPrice() {
        return cheapestPrice;
    }

    public void setCheapestPrice(Double cheapestPrice) {
        this.cheapestPrice = cheapestPrice;
    }

    public Double getMostExpensivePrice() {
        return mostExpensivePrice;
    }

    public void setMostExpensivePrice(Double mostExpensivePrice) {
        this.mostExpensivePrice = mostExpensivePrice;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Long getTotalBookSold() {
        return totalBookSold;
    }

    public void setTotalBookSold(Long totalBookSold) {
        this.totalBookSold = totalBookSold;
    }
}
