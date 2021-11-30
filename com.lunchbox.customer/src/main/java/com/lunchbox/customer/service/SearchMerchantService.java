package com.lunchbox.customer.service;

import com.lunchbox.customer.dto.CustomerDTO;

import java.util.List;

public interface SearchMerchantService {

    List<CustomerDTO> findByAddressState(String state);
}
