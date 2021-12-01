package com.lunchbox.customer.proxy;

import com.lunchbox.customer.dto.MerchantDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "customer-registration-service", url = "localhost:9090")
public interface MerchantProxy {

    @GetMapping(path = "/merchant/merchantId/{merchantId}")
    public MerchantDTO findById(@PathVariable String merchantId);

    @GetMapping(path = "/merchant/msisdn/{msisdn}")
    public MerchantDTO findByMsisdn(@PathVariable String msisdn);

}
