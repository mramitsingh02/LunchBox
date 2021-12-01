package com.lunchbox.customer.controller;

import com.lunchbox.common.errorfreamwork.exception.CustomerNotFoundException;
import com.lunchbox.customer.dto.CustomerDTO;
import com.lunchbox.customer.service.CustomerService;
import com.lunchbox.customer.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController(value = "customerService")
public class RestCustomerServiceController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private MerchantService merchantIdService;
/*
    //    @Autowired
    private MerchantProxy merchantProxy;
*/


    @PostMapping(path = "/customer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        var resCustomerDTO = customerService.save(customerDTO);

     /*   final MerchantDTO merchantDTO = merchantIdService.findById(customerDTO.getMerchantId());

        if (Objects.isNull(merchantDTO)) {
            throw new CustomerNotFoundException("Merchant not found.");
        }
*/
        return resCustomerDTO;

    }

    @PutMapping(path = "/customer/customerId/{customerId}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable String customerId) {
        var resCustomerDTO = customerService.update(customerDTO);
        return resCustomerDTO;
    }

    @DeleteMapping(path = "/customer/customerId/{customerId}")
    public CustomerDTO deleteById(@PathVariable String customerId) {
        CustomerDTO customerDTO = customerService.findById(customerId);

        if (Objects.nonNull(customerDTO)) {
            customerService.delete(customerDTO);
        } else {
            throw new CustomerNotFoundException("Customer Not Found!");
        }

        return customerDTO;
    }

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

    @GetMapping(path = "/customer/merchantId/{merchantId}")
    public List<CustomerDTO> findByMerchantId(@PathVariable String merchantId) {
        List<CustomerDTO> list = customerService.findByMerchantId(merchantId);
        return list;
    }

    @GetMapping(path = "/customer/all")
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> list = customerService.findAll();
        list.forEach(this::appendLinksToCustomers);
        return list;
    }

    private void appendLinksToCustomers(CustomerDTO customerDTO) {
        Link linkToAccessSelfWithMsisdn = linkTo(methodOn(RestCustomerServiceController.class).findByMsisdn(customerDTO.getMsisdn())).withRel("self-with-msisdn");
        Link linkToAccessSelfWithId = linkTo(methodOn(RestCustomerServiceController.class).findById(customerDTO.getCustomerId())).withRel("self-with-id");
        Link linkToAccessMerchantWithId = linkTo(methodOn(RestCustomerServiceController.class).findByMerchantId(customerDTO.getMerchantId())).withRel("merchant-with-id");
        customerDTO.add(linkToAccessSelfWithId, linkToAccessSelfWithMsisdn, linkToAccessMerchantWithId);
    }


}
