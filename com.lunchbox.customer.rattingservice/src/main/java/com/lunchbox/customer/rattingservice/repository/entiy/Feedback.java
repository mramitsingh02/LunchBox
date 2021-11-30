package com.lunchbox.customer.rattingservice.repository.entiy;

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
public class Feedback implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String messages;
    private String emailId;
    private LocalDate createdDate;
    private int ratting;

}
