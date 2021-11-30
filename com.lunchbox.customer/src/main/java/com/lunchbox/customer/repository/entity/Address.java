package com.lunchbox.customer.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Address implements Serializable {
    private String line1;
    private String line2;
    private String line3;
    private String state;
    private String city;
    private String zone;
    private String geography;
    private String pinCode;

}

