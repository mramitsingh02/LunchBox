package com.lunchbox.customer.rattingservice.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class AddressDTO {
    private String line1;
    private String line2;
    private String line3;
    private String state;
    private String city;
    private String zone;
    private String geography;
    private String pinCode;
    private boolean isNotPresent;


}
