package com.lunchbox.customer.repository;

import com.lunchbox.customer.repository.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantIdRepository extends JpaRepository<Merchant, String> {
    Merchant findByMsisdn(String msisdn);

    Merchant findByMsisdnAndStatus(String msisdn, String status);

    List<Merchant> findByStatus(String status);
}
