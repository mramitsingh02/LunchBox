package com.lunchbox.customer.controller;

import com.lunchbox.customer.dto.CustomerDTO;
import com.lunchbox.customer.service.SearchMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController(value = "searchService")
public class RestSearchController {
    @Autowired
    private SearchMerchantService searchMerchantService;

    @GetMapping(path = "/merchant/search")
    public List<CustomerDTO> findByMerchant(
            @RequestParam(required = true, value = "state") String state,
            @RequestParam(required = false, value = "city") String city,
            @RequestParam(required = false, value = "pinCode") String pinCode
            // @RequestParam(required = false, value = "ratting") float ratting
    ) {


        List<CustomerDTO> customerDTO = searchMerchantService.findByAddressState(state);
        Stream<CustomerDTO> customerStream = customerDTO.stream();

        customerStream = filter(customerStream, "city", city);
        customerStream = filter(customerStream, "pinCode", pinCode);
        //customerStream = filter(customerStream, "ratting", ratting);

        return customerStream.collect(Collectors.toList());
    }

    private Stream<CustomerDTO> filter(Stream<CustomerDTO> customerDTO, String attribute, String value) {
        if (Objects.isNull(value)) {
            return customerDTO;
        }
        switch (attribute) {
            case "city":
                return filterCity(customerDTO, value);
            case "pinCode":
                return filterPinCode(customerDTO, value);
        }
        return customerDTO;
    }

    private Stream<CustomerDTO> filter(Stream<CustomerDTO> customerDTO, String attribute, float value) {
        if (Objects.isNull(value)) {
            return customerDTO;
        }

        return customerDTO.filter(x -> x.getAddressDTO().getCity().equals(value));
    }

    private Stream<CustomerDTO> filterCity(Stream<CustomerDTO> customerDTO, String value) {
        return customerDTO.filter(x -> x.getAddressDTO().getCity().equals(value));
    }

    private Stream<CustomerDTO> filterPinCode(Stream<CustomerDTO> customerDTO, String value) {
        return customerDTO.filter(x -> x.getAddressDTO().getPinCode().equals(value));
    }


}
