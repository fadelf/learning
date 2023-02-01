package com.delfa.learning.dto;

import lombok.Data;

@Data
public class SalesDto {
    private Double cheapestPrice;
    private Double mostExpensivePrice;
    private Double totalSales;
    private Double averagePrice;
    private Long totalBookSold;
}
