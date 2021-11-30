package com.lunchbox.customer.controller;

import com.lunchbox.customer.dto.MerchantIdDTO;
import com.lunchbox.customer.service.MerchantIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/merchantIdService")
public class RestMerchantIdServiceController {
    @Autowired
    private MerchantIdService merchantIdService;

    @GetMapping(path = "/merchant/msisdn/{msisdn}")
    public MerchantIdDTO findByMsisdn(@PathVariable String msisdn) {
        MerchantIdDTO dto = merchantIdService.findByMsisdn(msisdn);
        return dto;
    }

    @GetMapping(path = "/merchant/merchantId/{merchantId}")
    public MerchantIdDTO findById(@PathVariable String merchantId) {
        MerchantIdDTO MerchantIdDTO = merchantIdService.findById(merchantId);
        return MerchantIdDTO;
    }

    @GetMapping(path = "/merchant/all")
    public List<MerchantIdDTO> findAll() {
        List<MerchantIdDTO> list = merchantIdService.findAll();
        return list;
    }

    @GetMapping(path = "/merchant/status/{status}")
    public List<MerchantIdDTO> findAll(@PathVariable String status) {
        List<MerchantIdDTO> list = merchantIdService.findByStatus(status);
        return list;
    }


    @PostMapping("/merchant")
    public MerchantIdDTO createMerchant(@RequestBody MerchantIdDTO MerchantIdDTO) {
        MerchantIdDTO resMerchantIdDTO = merchantIdService.save(MerchantIdDTO);
        return resMerchantIdDTO;

    }

    @PutMapping("/merchant")
    public MerchantIdDTO updateMerchant(@RequestBody MerchantIdDTO MerchantIdDTO) {
        MerchantIdDTO resMerchantIdDTO = merchantIdService.update(MerchantIdDTO);
        return resMerchantIdDTO;

    }

    @DeleteMapping("/merchant/merchantId/{merchantId}")
    public void deleteMerchant(@PathVariable String merchantId) {

        boolean deleted = merchantIdService.delete(merchantId);

    }

}
