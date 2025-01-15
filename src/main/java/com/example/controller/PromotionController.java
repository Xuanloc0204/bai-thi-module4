package com.example.controller;

import com.example.model.Promotion;
import com.example.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/promotions")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    /* ---------------- GET ALL PROMOTIONS ------------------------ */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        List<Promotion> promotions = (List<Promotion>) promotionService.findAll();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

    /* ---------------- GET PROMOTION BY ID ------------------------ */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Promotion> getPromotionById(@PathVariable Long id) {
        Promotion promotion = promotionService.getPromotionById(id);
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }

    /* ---------------- CREATE NEW PROMOTION ------------------------ */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion createdPromotion = promotionService.createPromotion(promotion);
        return new ResponseEntity<>(createdPromotion, HttpStatus.CREATED);
    }

    /* ---------------- UPDATE PROMOTION ------------------------ */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long id, @RequestBody Promotion updatedPromotion) {
        Promotion promotion = promotionService.updatePromotion(id, updatedPromotion);
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }

    /* ---------------- DELETE PROMOTION ------------------------ */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePromotion(@PathVariable Long id) {
        promotionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}