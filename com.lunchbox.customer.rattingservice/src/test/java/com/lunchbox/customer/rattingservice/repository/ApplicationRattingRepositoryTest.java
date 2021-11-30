package com.lunchbox.customer.rattingservice.repository;

import com.lunchbox.customer.rattingservice.repository.entiy.ApplicationRatting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class ApplicationRattingRepositoryTest {
    @Autowired
    private ApplicationRattingRepository rattingRepository;

    @Test
    public void createApplicationRatting() {
        rattingRepository.save(ApplicationRatting.builder().fromMsisdn("12345678").ratting(4.2f).description("Good Application").build());
    }

    @Test
    public void getApplicationRattingByMSISDN() {
        String msisdn = toMsisdn();
        rattingRepository.save(ApplicationRatting.builder().fromMsisdn(msisdn).ratting(4.2f).description("Good Application").build());
        final ApplicationRatting byFromMsisdn = rattingRepository.findByFromMsisdn(msisdn);
        Assertions.assertEquals(msisdn, byFromMsisdn.getFromMsisdn());

    }


    public String toMsisdn() {
        return String.valueOf(Math.abs(new Random(10).nextLong()));
    }
}
