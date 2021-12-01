package com.lunchbox.customer.merchant.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@JsonFilter("MerchantDetailsFilter")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDTO {
    private String merchantId;
    private String pin;
    private String msisdn;
    private LocalDate dateOfJoin;
    private String emailId;
    private String alternateEmailId;
    private boolean hasWallet;
    private boolean hasBank;
    private String walletSpecId;
    private String statuses;
    private LocalDate createUpdateDateTime;
    private LocalDate createdTime;
/*
    public MappingJacksonValue getMappingJacksonValue() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(this);
        MappingJacksonUtils.setFilterInMapping(MERCHANT_DETAILS_FILTER, mappingJacksonValue, MERCHANT_FIELDS);
        return mappingJacksonValue;
    }*/
}
