package com.lunchbox.customer.service;

import com.lunchbox.customer.dto.CustomerDTO;

import java.util.List;


public interface CustomerService {
    CustomerDTO findByMsisdn(String msisdn);

    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO findById(String customerId);

    List<CustomerDTO> findAll();

    List<CustomerDTO> findByMerchantId(String merchantId);

    List<CustomerDTO> findByAddressState(String state);

    CustomerDTO update(CustomerDTO customerDTO);

    void delete(CustomerDTO customerDTO);
}
