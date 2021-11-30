package com.lunchbox.customer.merchant.persistance;

import com.lunchbox.customer.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {

    Optional<Merchant> findByMsisdn(String msisdn);


}
