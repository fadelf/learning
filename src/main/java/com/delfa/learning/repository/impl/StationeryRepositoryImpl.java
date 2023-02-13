package com.delfa.learning.repository.impl;

import com.delfa.learning.model.Stationery;
import com.delfa.learning.repository.StationeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StationeryRepositoryImpl implements StationeryRepository {

    private RedisTemplate<String, Stationery> redisTemplate;
    private HashOperations hashOperations;

    public StationeryRepositoryImpl(RedisTemplate<String, Stationery> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Stationery stationery) {
        hashOperations.put("stationery", stationery.getId(), stationery);
    }

    @Override
    public Map<String, Stationery> findAll() {
        return hashOperations.entries("stationery");
    }

    @Override
    public Stationery findById(String id) {
        return (Stationery) hashOperations.get("stationery", id);
    }

    @Override
    public void update(Stationery stationery) {
        save(stationery);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("stationery", id);
    }
}
