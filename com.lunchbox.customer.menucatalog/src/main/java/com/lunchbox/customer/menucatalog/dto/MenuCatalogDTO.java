package com.lunchbox.customer.menucatalog.dto;

import com.lunchbox.customer.rattingservice.repository.entiy.MealType;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuCatalogDTO {
    private Long catalogId;
    private String menuName;
    private MealType mealType;
    private List<ItemsDTO> items;
    private LocalDate createdDate;
    private float ratting;
}
