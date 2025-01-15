package com.example.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name = "promotion")
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Tiêu đề khuyến mãi

    private LocalDateTime startDate; // Thời gian bắt đầu

    private LocalDateTime endDate; // Thời gian kết thúc

    private Double discount; // Mức giảm giá

    private String details; // Chi tiết khuyến mãi

}

