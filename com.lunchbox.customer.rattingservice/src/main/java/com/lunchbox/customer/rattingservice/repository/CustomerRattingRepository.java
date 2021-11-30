package com.lunchbox.customer.rattingservice.repository;

import com.lunchbox.customer.rattingservice.repository.entiy.CustomerRatting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRattingRepository extends JpaRepository<CustomerRatting, Long> {
    CustomerRatting findByFromMsisdn(String fromMsisdn);

    List<CustomerRatting> findByToMsisdn(String msisdn);
}
