package com.lunchbox.customer.rattingservice.service.mapper;

import com.lunchbox.customer.rattingservice.dto.ApplicationRattingDTO;
import com.lunchbox.customer.rattingservice.dto.CustomerRattingDTO;
import com.lunchbox.customer.rattingservice.repository.entiy.ApplicationRatting;
import com.lunchbox.customer.rattingservice.repository.entiy.CustomerRatting;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class RattingMapper {
    public static List<ApplicationRattingDTO> getApplicationRatting(List<ApplicationRatting> all) {
        return all.stream().map(RattingMapper::getApplicationRattingDTO).collect(Collectors.toList());
    }

    public static List<CustomerRattingDTO> getCustomerRattingDTO(List<CustomerRatting> all) {
        return all.stream().map(RattingMapper::getCustomerRattingDTO).collect(Collectors.toList());
    }

    public static CustomerRattingDTO getCustomerRattingDTO(CustomerRatting customerRatting) {
        if (isNull(customerRatting)) {
            return null;
        }
        return CustomerRattingDTO.builder()
                .rattingId(customerRatting.getRattingId())
                .ratting(customerRatting.getRatting())
                .fromMsisdn(customerRatting.getFromMsisdn())
                .fromCustomerId(customerRatting.getFromCustomerId())
                .toMsisdn(customerRatting.getToMsisdn())
                .toCustomerId(customerRatting.getToCustomerId())
                .description(customerRatting.getDescription())
                .build();
    }

    public static ApplicationRattingDTO getApplicationRattingDTO(ApplicationRatting applicationRatting) {
        if (isNull(applicationRatting)) {
            return null;
        }
        return ApplicationRattingDTO.builder()
                .rattingId(applicationRatting.getRattingId())
                .ratting(applicationRatting.getRatting())
                .fromMsisdn(applicationRatting.getFromMsisdn())
                .description(applicationRatting.getDescription())
                .build();
    }

    public static ApplicationRatting getApplicationRatting(ApplicationRattingDTO applicationRattingDTO) {
        if (isNull(applicationRattingDTO)) {
            return null;
        }
        return ApplicationRatting.builder()
                .rattingId(applicationRattingDTO.getRattingId())
                .ratting(applicationRattingDTO.getRatting())
                .fromMsisdn(applicationRattingDTO.getFromMsisdn())
                .description(applicationRattingDTO.getDescription())
                .build();
    }

    public static CustomerRatting getCustomerRatting(CustomerRattingDTO customerRattingDTO) {
        if (isNull(customerRattingDTO)) {
            return null;
        }
        return CustomerRatting.builder()
                .rattingId(customerRattingDTO.getRattingId())
                .ratting(customerRattingDTO.getRatting())
                .fromMsisdn(customerRattingDTO.getFromMsisdn())
                .fromCustomerId(customerRattingDTO.getFromCustomerId())
                .toMsisdn(customerRattingDTO.getToMsisdn())
                .toCustomerId(customerRattingDTO.getToCustomerId())
                .description(customerRattingDTO.getDescription())
                .build();
    }
}
