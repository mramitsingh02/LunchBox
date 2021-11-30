package com.lunchbox.customer.repository;

import com.lunchbox.customer.repository.entity.MerchantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantIdRepository extends JpaRepository<MerchantId, String> {
    MerchantId findByMsisdn(String msisdn);

    MerchantId findByMsisdnAndStatus(String msisdn, String status);

    List<MerchantId> findByStatus(String status);
}
