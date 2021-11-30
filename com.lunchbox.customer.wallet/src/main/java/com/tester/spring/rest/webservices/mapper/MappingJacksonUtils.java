package com.tester.spring.rest.webservices.mapper;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tester.spring.rest.webservices.dto.WalletDTO;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.util.List;

import static com.tester.spring.rest.webservices.controller.RestConstants.WALLET_DETAILS_FILTER;
import static com.tester.spring.rest.webservices.controller.RestConstants.WALLET_FIELDS;

public class MappingJacksonUtils {

    public static MappingJacksonValue getMappingJackson(String filterId, List<WalletDTO> accountDetails, String[] nameOfFilterAttributes) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(accountDetails);

        mappingJacksonValue.setFilters(getFilterProvider(filterId, nameOfFilterAttributes));
        return mappingJacksonValue;
    }

    public static MappingJacksonValue getMappingJackson(String filterId, WalletDTO walletDTO, String[] nameOfFilterAttributes) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(walletDTO);

        mappingJacksonValue.setFilters(getFilterProvider(filterId, nameOfFilterAttributes));
        return mappingJacksonValue;
    }

    private static FilterProvider getFilterProvider(String filterId, String[] nameOfFilterAttributes) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(nameOfFilterAttributes);
        return new SimpleFilterProvider().addFilter(filterId, filter);
    }

    public static MappingJacksonValue getWalletFilter(WalletDTO walletDTO) {
        return getMappingJackson(WALLET_DETAILS_FILTER, walletDTO, WALLET_FIELDS);
    }

    public static MappingJacksonValue getWalletFilter(List<WalletDTO> accountDetails) {
        return getMappingJackson(WALLET_DETAILS_FILTER, accountDetails, WALLET_FIELDS);
    }
}
