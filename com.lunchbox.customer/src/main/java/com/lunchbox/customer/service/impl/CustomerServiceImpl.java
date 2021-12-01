package com.lunchbox.customer.service.impl;

import com.lunchbox.common.errorfreamwork.exception.CustomerNotFoundException;
import com.lunchbox.customer.dto.CustomerDTO;
import com.lunchbox.customer.repository.CustomerRepository;
import com.lunchbox.customer.repository.entity.Customer;
import com.lunchbox.customer.service.CustomerService;
import com.lunchbox.customer.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO findByMsisdn(String msisdn) {
        final Customer customerRepositoryByMsisdn = customerRepository.findByMsisdn(msisdn);
        if (isNull(customerRepositoryByMsisdn)) {
            throw new CustomerNotFoundException("Customer %s Not found.", msisdn);
        }

        return CustomerMapper.getCustomerDTO(customerRepositoryByMsisdn);
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(UUID.randomUUID().toString());
//        customerDTO.setMerchantId();
        return CustomerMapper.getCustomerDTO(customerRepository.save(CustomerMapper.getCustomer(customerDTO)));
    }

    @Override
    public CustomerDTO findById(String customerId) {
        return CustomerMapper.getCustomerDTO(customerRepository.getById(customerId));
    }

    @Override
    public List<CustomerDTO> findAll() {
        return CustomerMapper.getCustomers(customerRepository.findAll());
    }

    @Override
    public List<CustomerDTO> findByAddressState(String state) {
        return CustomerMapper.getCustomers(customerRepository.findByAddressState(state));
    }

    @Override
    public List<CustomerDTO> findByMerchantId(String merchantId) {
        return CustomerMapper.getCustomers(customerRepository.findByMerchantId(merchantId));
    }


    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return CustomerMapper.getCustomerDTO(customerRepository.saveAndFlush(CustomerMapper.getCustomer(customerDTO)));
    }

    @Override
    public void delete(CustomerDTO customerDTO) {
        customerRepository.delete((CustomerMapper.getCustomer(customerDTO)));
    }
}
