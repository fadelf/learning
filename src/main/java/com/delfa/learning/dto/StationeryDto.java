package com.delfa.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationeryDto {
    private String name;
    private Double price;
    private LocalDate productionDate;
}
