package com.lunchbox.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantCustomersDTO extends RepresentationModel<MerchantCustomersDTO> {
    private String merchantId;
    private String merchantMsisdn;
    private List<CustomerDTO> customers;
}
