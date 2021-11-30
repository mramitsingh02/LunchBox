package com.lunchbox.customer.rattingservice.service;

import com.lunchbox.customer.rattingservice.dto.ApplicationRattingDTO;
import com.lunchbox.customer.rattingservice.dto.CustomerRattingDTO;
import com.lunchbox.customer.rattingservice.rest.MerchantRattingResponse;

import java.util.List;

public interface RattingService {
    List<ApplicationRattingDTO> getApplicationRatting();

    List<CustomerRattingDTO> getCustomerRatting();

    CustomerRattingDTO getCustomerRatting(String msisdn);

    CustomerRattingDTO save(CustomerRattingDTO customerRattingDTO);

    ApplicationRattingDTO save(ApplicationRattingDTO applicationRattingDTO);

    ApplicationRattingDTO getApplicationRattingByFromMsisdn(String fromMsisdn);

    ApplicationRattingDTO createOrUpdateRatting(ApplicationRattingDTO applicationRattingDTO);

    CustomerRattingDTO createOrUpdateRatting(CustomerRattingDTO customerRattingDTO);

    CustomerRattingDTO getCustomerRattingFromMsisdn(String fromMsisdn);

    MerchantRattingResponse getMerchantRattingByMsisdn(String msisdn);
}
