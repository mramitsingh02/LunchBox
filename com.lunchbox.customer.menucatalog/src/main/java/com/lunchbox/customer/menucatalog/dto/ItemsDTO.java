package com.lunchbox.customer.menucatalog.dto;

import com.lunchbox.customer.rattingservice.repository.entiy.MealType;

import java.time.LocalDate;
import java.util.List;

public class ItemsDTO {
    private Long catalogId;
    private String menuName;
    private MealType mealType;
    private List<ItemsDTO> items;
    private LocalDate createdDate;
    private float ratting;
}
