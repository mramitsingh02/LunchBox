package com.lunchbox.customer.rattingservice.proxy;

import com.lunchbox.customer.rattingservice.dto.CustomerDTO;
import com.lunchbox.customer.rattingservice.dto.MerchantIdDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-registration-service", url = "localhost:9090")
public interface CustomerManagementProxy {

    @GetMapping(path = "/customer/msisdn/{msisdn}")
    public CustomerDTO retrieveCustomerByMsisdn(@PathVariable("msisdn") String msisdn);

    @GetMapping(path = "/merchant/msisdn/{msisdn}")
    public MerchantIdDTO retrieveMerchantByMsisdn(@PathVariable("msisdn") String msisdn);

}
