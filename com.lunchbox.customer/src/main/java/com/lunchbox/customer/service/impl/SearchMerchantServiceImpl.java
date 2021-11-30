package com.lunchbox.customer.service.impl;

import com.lunchbox.customer.dto.CustomerDTO;
import com.lunchbox.customer.repository.CustomerRepository;
import com.lunchbox.customer.service.SearchMerchantService;
import com.lunchbox.customer.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchMerchantServiceImpl implements SearchMerchantService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> findByAddressState(String state) {
        return CustomerMapper.getCustomers(customerRepository.findByAddressState(state));
    }
}
