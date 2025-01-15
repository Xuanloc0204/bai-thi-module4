package com.example.repository;

import com.example.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByDiscount(Double discount);
}
