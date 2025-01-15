package com.example.service;

import com.example.model.Promotion;

import java.util.List;

public interface IPromotionService extends IGenerateService<Promotion>  {
    Promotion getPromotionById(Long id);
    Promotion updatePromotion(Long id, Promotion promotion);
    List<Promotion> searchByDiscount(Double discount);
    Promotion createPromotion(Promotion promotion);
}
