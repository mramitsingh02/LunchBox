package com.lunchbox.customer.service.mapper;

import com.lunchbox.customer.dto.AddressDTO;
import com.lunchbox.customer.dto.CustomerDTO;
import com.lunchbox.customer.repository.entity.Address;
import com.lunchbox.customer.repository.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static Customer getCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .firstName(customerDTO.getFirstName())
                .middleName(customerDTO.getMiddleName())
                .lastName(customerDTO.getLastName())
                .customerId(customerDTO.getCustomerId())
                .dob(customerDTO.getDob())
                .emailId(customerDTO.getEmailId())
                .msisdn(customerDTO.getMsisdn())
                .merchantId(customerDTO.getMerchantId())
                .pin(customerDTO.getPin())
                .walletId(customerDTO.getWalletId())
                .walletSpecId(customerDTO.getWalletSpecId())
                .status(customerDTO.getStatus())
                .address(getAddress(Optional.ofNullable(customerDTO.getAddressDTO())))
                .build();
    }

    private static Address getAddress(Optional<AddressDTO> addressSafe) {
        if (!addressSafe.isPresent())
            return Address.builder().build();

        final AddressDTO address = addressSafe.get();
        return Address.builder()
                .line1(address.getLine1())
                .line2(address.getLine2())
                .line3(address.getLine3())
                .state(address.getState())
                .city(address.getCity())
                .zone(address.getZone())
                .geography(address.getGeography())
                .pinCode(address.getPinCode())
                .build();
    }

    public static CustomerDTO getCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .customerId(customer.getCustomerId())
                .dob(customer.getDob())
                .emailId(customer.getEmailId())
                .msisdn(customer.getMsisdn())
                .pin(customer.getPin())
                .merchantId(customer.getMerchantId())
                .walletId(customer.getWalletId())
                .walletSpecId(customer.getWalletSpecId())
                .status(customer.getStatus())
                .addressDTO(getAddressDTO(customer.getAddressSafe()))
                .build();
    }

    private static AddressDTO getAddressDTO(Optional<Address> addressSafe) {
        if (!addressSafe.isPresent())
            return AddressDTO.builder().isNotPresent(true).build();

        final Address address = addressSafe.get();
        return AddressDTO.builder()
                .isNotPresent(false)
                .line1(address.getLine1())
                .line2(address.getLine2())
                .line3(address.getLine3())
                .state(address.getState())
                .city(address.getCity())
                .zone(address.getZone())
                .geography(address.getGeography())
                .pinCode(address.getPinCode())
                .build();
    }

    public static List<CustomerDTO> getCustomers(List<Customer> all) {
        return all.stream().map(CustomerMapper::getCustomerDTO).collect(Collectors.toList());
    }
}
