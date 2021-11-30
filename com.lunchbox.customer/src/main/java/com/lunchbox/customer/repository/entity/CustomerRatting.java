package com.lunchbox.customer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CustomerRatting {
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
