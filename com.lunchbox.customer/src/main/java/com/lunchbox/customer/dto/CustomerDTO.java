package com.lunchbox.customer.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
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
