package com.delfa.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("stationery")
public class Stationery implements Serializable {

    @Id
    private String id;
    private String name;
    private Double price;
    private LocalDate productionDate;
}
