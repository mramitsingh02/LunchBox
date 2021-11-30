package com.lunchbox.customer.menucatalog.repository.entiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuCatalog implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String msisdn;
    private String merchantId;
    private LocalDate createdDate;
    private int ratting;

}
