package com.lunchbox.customer.rattingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String customerId;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dob;
    private String msisdn;
    private String merchantId;
    private String pin;
    private String emailId;
    private String status;
    private String walletSpecId;
    private String walletId;
    private AddressDTO addressDTO;

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
