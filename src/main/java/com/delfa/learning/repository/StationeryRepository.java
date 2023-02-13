package com.delfa.learning.repository;

import com.delfa.learning.model.Stationery;

import java.util.Map;

public interface StationeryRepository {
    void save(Stationery stationery);
    Map<String, Stationery> findAll();
    Stationery findById(String id);
    void update(Stationery stationery);
    void delete(String id);
}
