package com.lunchbox.customer.controller;

import com.lunchbox.customer.dto.CustomerDTO;
import com.lunchbox.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "customerService")
public class RestCustomerServiceController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customer/msisdn/{msisdn}")
    public CustomerDTO findByMsisdn(@PathVariable String msisdn) {
        CustomerDTO customerDTO = customerService.findByMsisdn(msisdn);

        
        return customerDTO;
    }

    @GetMapping(path = "/customer/customerId/{customerId}")
    public CustomerDTO findById(@PathVariable String customerId) {
        CustomerDTO customerDTO = customerService.findById(customerId);
        return customerDTO;
    }

    @GetMapping(path = "/customer/all")
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> list = customerService.findAll();
        return list;
    }

    @GetMapping(path = "/customer/merchantId/{merchantId}")
    public List<CustomerDTO> findByMerchantId(@PathVariable String merchantId) {
        List<CustomerDTO> list = customerService.findByMerchantId(merchantId);
        return list;
    }

    @PostMapping(path = "/customer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {

        var resCustomerDTO = customerService.save(customerDTO);

        return resCustomerDTO;

    }

    @PutMapping(path = "/customer")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {

        var resCustomerDTO = customerService.update(customerDTO);

        return resCustomerDTO;

    }

}
