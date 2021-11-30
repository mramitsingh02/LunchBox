package com.lunchbox.customer.rattingservice.repository.entiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "customer_ratting")
@Builder
public class CustomerRatting implements Serializable {
    @Id
    @GeneratedValue
    private Long rattingId;
    private String fromMsisdn;
    private String fromCustomerId;
    private String toMsisdn;
    private String toCustomerId;
    private float ratting;
    private String description;

}
