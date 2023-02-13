package com.delfa.learning.controller;

import com.delfa.learning.dto.StationeryDto;
import com.delfa.learning.model.Stationery;
import com.delfa.learning.repository.StationeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("stationery")
public class StationeryController {

    @Autowired
    private StationeryRepository stationeryRepository;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createStationery(@RequestBody StationeryDto stationeryDto) {
        Stationery stationery = new Stationery();
        stationery.setId(UUID.randomUUID().toString());
        stationery.setName(stationeryDto.getName());
        stationery.setPrice(stationeryDto.getPrice());
        stationery.setProductionDate(stationeryDto.getProductionDate());
        stationeryRepository.save(stationery);

        return new ResponseEntity<>("Create Success", HttpStatus.OK);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findAllStationery() {
        Map<String, Stationery> stationeryMap = stationeryRepository.findAll();

        return new ResponseEntity<>(stationeryMap, HttpStatus.OK);
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findStationeryById(@PathVariable String id) {
        Stationery stationery = stationeryRepository.findById(id);

        return new ResponseEntity<>(stationery, HttpStatus.OK);
    }

    @RequestMapping(path = "/update")
    public ResponseEntity<?> updateStationery(@RequestBody Stationery stationery) {
        stationeryRepository.update(stationery);

        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStationery(@PathVariable String id) {
        stationeryRepository.delete(id);

        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
