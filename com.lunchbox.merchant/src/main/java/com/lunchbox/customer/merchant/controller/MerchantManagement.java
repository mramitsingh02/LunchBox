package com.lunchbox.customer.merchant.controller;

import com.lunchbox.customer.merchant.dto.MerchantDTO;
import com.lunchbox.customer.merchant.service.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/merchant")
public class MerchantManagement {

    @Autowired
    private MerchantServices merchantServices;


    @PostMapping("/")
    public MappingJacksonValue create(@Valid @RequestBody MerchantDTO MerchantDTO) {
        final MerchantDTO wallet = this.merchantServices.save(MerchantDTO);
        return wallet.getMappingJacksonValue();
    }

    @GetMapping(path = "/msisdn/{msisdn}")
    public MappingJacksonValue findByMsisdn(@PathVariable String msisdn) {
        MerchantDTO wallet = this.merchantServices.findByMsisdn(msisdn);
        return wallet.getMappingJacksonValue();
    }


    @GetMapping(path = "/msisdn/{msisdn}/pin/{pin}")
    public MappingJacksonValue findByMsisdnAndPin(@PathVariable String msisdn, @PathVariable String pin) {
        MerchantDTO wallet = this.merchantServices.findByMsisdnAndPin(msisdn, pin);
        return wallet.getMappingJacksonValue();
    }
/*

    @PutMapping(path = "/msisdn/{msisdn}")
    public MappingJacksonValue changePin(@PathVariable String msisdn, @RequestBody ChangePinDTO changePin) {
        MerchantDTO wallet = this.merchantServices.changePin (msisdn, changePin);
        return wallet.getMappingJacksonValue ();
    }

    @GetMapping(path = "/All")
    public MappingJacksonValue findAll() {
        List<MerchantDTO> merchants = this.merchantServices.findAll ();
        return MappingJacksonUtils.getMappingJacksonValues (merchants);
    }

    @GetMapping("/walletNumber/{walletNumber}/pin/{pin}")
    public MappingJacksonValue getWalletByPin(@PathVariable String walletNumber, @PathVariable String pin) {
        MerchantDTO wallet = this.merchantServices.findByWalletNumber (walletNumber);
        if (wallet.getPin ().equals (pin)) return wallet.getMappingJacksonValue ();
        throw new AccountAuthenticationException("Account number and pin not exception.");
    }

    @GetMapping("/walletNumber/{walletNumber}")
    public MappingJacksonValue getWallet(@PathVariable String walletNumber) {
        MerchantDTO wallet = this.merchantServices.findByWalletNumber (walletNumber);
        return wallet.getMappingJacksonValue ();
    }

    @DeleteMapping("/walletNumber/{walletNumber}")
    public void deleteByWallet(@PathVariable String walletNumber) {
        this.merchantServices.deleteByWalletNumber (walletNumber);
    }


    @DeleteMapping(path = "/msisdn/{msisdn}/pin/{pin}")
    public void deleteByMsisdnAndPin(@PathVariable String msisdn, @PathVariable String pin) {
        this.merchantServices.deleteByMsisdnAndPin (msisdn, pin);
    }
*/

/*

    @PostMapping("/wallet-v1")
    public Resource<MerchantDTO> merchant(@Valid @RequestBody MerchantDTO MerchantDTO) {
        final MerchantDTO wallet = this.merchantServices.save(MerchantDTO);
        return getWalletResource(wallet);
    }

    private Resource<MerchantDTO> getWalletResource(MerchantDTO merchantDTO) {
        Resource<MerchantDTO> resource = new Resource<>(merchantDTO);
        Link linkBuilder = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findByMsisdn(merchantDTO.getMsisdn())).withSelfRel();
        resource.add(linkBuilder);
        return resource;
    }
*/


}
