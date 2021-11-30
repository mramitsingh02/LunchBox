package com.lunchbox.customer.repository;

import com.lunchbox.customer.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByMsisdn(String msisdn);

    List<Customer> findByMerchantId(String merchantId);

    List<Customer> findByAddressState(String state);
}
