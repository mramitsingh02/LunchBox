package com.lunchbox.customer.rattingservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.lunchbox.customer.rattingservice.dto.ApplicationRattingDTO;
import com.lunchbox.customer.rattingservice.dto.CustomerDTO;
import com.lunchbox.customer.rattingservice.dto.CustomerRattingDTO;
import com.lunchbox.customer.rattingservice.dto.MerchantIdDTO;
import com.lunchbox.customer.rattingservice.rest.ApplicationRattingResponse;
import com.lunchbox.customer.rattingservice.rest.MerchantRattingResponse;
import com.lunchbox.customer.rattingservice.service.RattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController(value = "customerRattingService")
public class RestCustomerRattingController {
    @Autowired
    private RattingService rattingService;

    @GetMapping(path = "/ratting/application")
    public List<ApplicationRattingDTO> getApplicationRattings() {
        List<ApplicationRattingDTO> rattingDTO = rattingService.getApplicationRatting();
        for (ApplicationRattingDTO applicationRattingDTO : rattingDTO) {
            Link link = linkTo(methodOn(RestCustomerRattingController.class).getApplicationRatting(applicationRattingDTO.getFromMsisdn())).withSelfRel();
            applicationRattingDTO.add(link);
        }

        return rattingDTO;
    }

    @GetMapping(path = "/ratting/application/statistics", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityModel<ApplicationRattingResponse> applicationRattingStatistics() {
        List<ApplicationRattingDTO> rattingDTO = rattingService.getApplicationRatting();

        rattingDTO.forEach(applicationRattingDTO -> applicationRattingDTO.add(getApplicationRattingLink(applicationRattingDTO.getFromMsisdn())));
        Link selfLink = linkTo((methodOn(RestCustomerRattingController.class)).applicationRattingStatistics()).withSelfRel();
        return EntityModel.of(ApplicationRattingResponse.newBuilder().setRatting(rattingDTO).build(), selfLink);
    }

    private Link getApplicationRattingLink(String msisdn) {
        return linkTo(methodOn(RestCustomerRattingController.class).getApplicationRatting(msisdn)).withSelfRel();
    }


    @GetMapping(path = "/ratting/application/msisdn/{msisdn}")
    public ApplicationRattingDTO getApplicationRatting(@PathVariable String msisdn) {
        ApplicationRattingDTO customerRattingDTO = rattingService.getApplicationRattingByFromMsisdn(msisdn);
        return customerRattingDTO;
    }


    @PostMapping(path = "/ratting/application")
    public EntityModel<ApplicationRattingDTO> createApplicationRatting(@RequestBody ApplicationRattingDTO applicationRattingDTO) {
        final ApplicationRattingDTO rattingDTO = rattingService.createOrUpdateRatting(applicationRattingDTO);
        Link link = linkTo(methodOn(RestCustomerRattingController.class).getApplicationRatting(rattingDTO.getFromMsisdn())).withSelfRel();
        Link allRatting = linkTo(methodOn(RestCustomerRattingController.class).getApplicationRattings()).withRel("all-application-ratting");
        return EntityModel.of(rattingDTO, link, allRatting);
    }

    @GetMapping(path = "/ratting/customer/all")
    public CollectionModel<CustomerRattingDTO> allCustomerRatting() {
        List<CustomerRattingDTO> customerRattingDTO = rattingService.getCustomerRatting();
        for (CustomerRattingDTO dto : customerRattingDTO) {
            dto.add(linkTo(methodOn(RestCustomerRattingController.class).getCustomerRatting(dto.getFromMsisdn())).withSelfRel());
        }
        return CollectionModel.of(customerRattingDTO);
    }

    @GetMapping(path = "/ratting/customer/msisdn/{msisdn}")
    public CustomerRattingDTO getCustomerRatting(@PathVariable String msisdn) {
        CustomerRattingDTO customerRattingDTO = rattingService.getCustomerRatting(msisdn);
        return customerRattingDTO;
    }


    @GetMapping(path = "/merchant/ratting/msisdn/{msisdn}")
    public MerchantRattingResponse getMerchantRattingResponse(@PathVariable String msisdn) {
        return rattingService.getMerchantRattingByMsisdn(msisdn);
    }


    private MappingJacksonValue getMappingJacksonValue(List<CustomerRattingDTO> accountDetails, String filterId, String... nameOfFilterAttributes) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(accountDetails);
        setFilterInMapping(filterId, mappingJacksonValue, nameOfFilterAttributes);
        return mappingJacksonValue;
    }

    private void setFilterInMapping(String filterId, MappingJacksonValue mappingJacksonValue, String[] nameOfFilterAttributes) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(nameOfFilterAttributes);
        FilterProvider filters = new SimpleFilterProvider().addFilter(filterId, filter);
        mappingJacksonValue.setFilters(filters);
    }

    @PostMapping(path = "/ratting/customer")
    public CustomerRattingDTO createCustomerRatting(@RequestBody CustomerRattingDTO customerRattingDTO) {
        String uri = "http://localhost:9090/customer/msisdn/{msisdn}";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriParamMap = new HashMap<>();
        uriParamMap.put("msisdn", customerRattingDTO.getFromMsisdn());
        ResponseEntity<CustomerDTO> fromCustomer = restTemplate.getForEntity(uri, CustomerDTO.class, uriParamMap);
        uriParamMap.put("msisdn", customerRattingDTO.getToMsisdn());

        if (fromCustomer.hasBody()) {
            customerRattingDTO.setFromCustomerId(fromCustomer.getBody().getCustomerId());
        }

        uri = "http://localhost:9090/merchant/msisdn/{msisdn}";
        ResponseEntity<MerchantIdDTO> toMerchant = restTemplate.getForEntity(uri, MerchantIdDTO.class, uriParamMap);
        if (toMerchant.hasBody()) {
            customerRattingDTO.setToCustomerId(toMerchant.getBody().getMerchantId());
        }
        return rattingService.createOrUpdateRatting(customerRattingDTO);
    }

}
