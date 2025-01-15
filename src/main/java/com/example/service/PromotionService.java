package com.example.service;

import com.example.model.Promotion;
import com.example.repository.IPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService implements IPromotionService{

    @Autowired
    private IPromotionRepository promotionRepository;

    @Override
    public Iterable<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Promotion object) {
        promotionRepository.save(object);

    }

    @Override
    public void deleteById(Long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id).orElseThrow(() -> new RuntimeException("Promotion not found"));
    }

    @Override
    public Promotion updatePromotion(Long id, Promotion promotion) {
        Promotion existingPromotion = getPromotionById(id);
        existingPromotion.setTitle(promotion.getTitle());
        existingPromotion.setStartDate(promotion.getStartDate());
        existingPromotion.setEndDate(promotion.getEndDate());
        existingPromotion.setDiscount(promotion.getDiscount());
        existingPromotion.setDetails(promotion.getDetails());
        promotionRepository.save(existingPromotion);
        return existingPromotion;
    }

    @Override
    public List<Promotion> searchByDiscount(Double discount) {
        return promotionRepository.findByDiscount(discount);
    }

    @Override
    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }
}
