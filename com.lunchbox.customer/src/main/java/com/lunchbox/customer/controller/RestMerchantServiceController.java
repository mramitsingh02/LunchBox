package com.lunchbox.customer.controller;

import com.lunchbox.common.errorfreamwork.exception.CustomerNotFoundException;
import com.lunchbox.common.errorfreamwork.exception.ProcessingException;
import com.lunchbox.customer.dto.CustomerDTO;
import com.lunchbox.customer.dto.MerchantDTO;
import com.lunchbox.customer.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;


@RestController(value = "/merchantIdService")
public class RestMerchantServiceController {
    @Autowired
    private MerchantService merchantService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(path = "/merchant/msisdn/{msisdn}")
    public MerchantDTO findByMsisdn(@PathVariable String msisdn) {
        MerchantDTO dto = merchantService.findByMsisdn(msisdn).orElseThrow(() -> new CustomerNotFoundException("Merchant not found."));

        dto.add(linkTo(WebFluxLinkBuilder.methodOn(RestMerchantServiceController.class).findById(dto.getMerchantId())).withSelfRel());

        return dto;
    }

    @GetMapping(path = "/merchant/merchantId/{merchantId}")
    public MerchantDTO findById(@PathVariable String merchantId) {
        MerchantDTO merchantDTO = merchantService.findById(merchantId).orElseThrow(() -> new CustomerNotFoundException("Merchant not found."));
        return merchantDTO;
    }

    private void checkMerchantAvailability() {
        throw new CustomerNotFoundException("Merchant not found.");
    }

    @GetMapping(path = "/merchant/all")
    public List<MerchantDTO> findAll() {
        List<MerchantDTO> list = merchantService.findAll();
        list.forEach(this::appendLinksToMerchants);
        return list;
    }

    private void appendLinksToMerchants(MerchantDTO merchantDTO) {
        merchantDTO.add(linkToAccessSelfWithId(merchantDTO), linkToAccessSelfWithMsisdn(merchantDTO));
    }

    private Link linkToAccessSelfWithId(MerchantDTO merchantDTO) {
        return linkTo(methodOn(RestMerchantServiceController.class).findById(merchantDTO.getMerchantId())).withRel("self-with-id");
    }

    private Link linkToAccessSelfWithMsisdn(MerchantDTO merchantDTO) {
        return linkTo(methodOn(RestMerchantServiceController.class).findByMsisdn(merchantDTO.getMsisdn())).withRel("self-with-msisdn");
    }

    @GetMapping(path = "/merchant/status/{status}")
    public List<MerchantDTO> findAll(@PathVariable String status) {
        List<MerchantDTO> list = merchantService.findByStatus(status);
        list.forEach(this::appendLinksToMerchants);
        return list;
    }


    @PostMapping("/merchant")
//    @TimeRecorder
    public MerchantDTO createMerchant(@RequestBody MerchantDTO MerchantDTO) {
        MerchantDTO resMerchantDTO = merchantService.save(MerchantDTO).orElseThrow(() -> new ProcessingException("Persistent issue."));
        return resMerchantDTO;

    }

    @PostMapping("/merchant/merchantId/{merchantId}/customerId/{customerId}")
    public MerchantDTO linkCustomerWithMerchant(@PathVariable String merchantId, @PathVariable String customerId) {
        MerchantDTO resMerchantDTO = findById(merchantId);


        String url = "/customer/customerId/{customerId}";
        final ResponseEntity<CustomerDTO> customerResponse = restTemplate.getForEntity(url, CustomerDTO.class, Map.of("customerId", customerId));
        if (customerResponse.hasBody()) {

        }


        return resMerchantDTO;

    }

    @PutMapping("/merchant/merchantId/{merchantId}")
    public MerchantDTO updateMerchant(@RequestBody MerchantDTO MerchantDTO, @PathVariable String merchantId) {
        MerchantDTO resMerchantDTO = merchantService.update(MerchantDTO).get();
        resMerchantDTO.add(linkToAccessSelfWithId(resMerchantDTO));
        return resMerchantDTO;

    }

    @DeleteMapping("/merchant/merchantId/{merchantId}")
    public void deleteMerchant(@PathVariable String merchantId) {

        boolean deleted = merchantService.delete(merchantId);

    }

}
