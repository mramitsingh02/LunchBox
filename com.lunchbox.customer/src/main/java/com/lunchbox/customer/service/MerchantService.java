package com.lunchbox.customer.service;

import com.lunchbox.customer.dto.MerchantDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MerchantService {
    Optional<MerchantDTO> findByMsisdn(String msisdn);

    Optional<MerchantDTO> save(MerchantDTO merchantDTO);

    Optional<MerchantDTO> findById(String merchantId);

    Optional<MerchantDTO> findByIdAndStatus(String merchantId, String status);

    List<MerchantDTO> findAll();

    Optional<MerchantDTO> update(MerchantDTO merchantDTO);

    boolean delete(String merchantId);

    List<MerchantDTO> findByStatus(String status);
}
