package com.lunchbox.customer.service;

import com.lunchbox.customer.dto.MerchantIdDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MerchantIdService {
    MerchantIdDTO findByMsisdn(String msisdn);

    MerchantIdDTO save(MerchantIdDTO merchantIdDTO);

    MerchantIdDTO findById(String merchantId);

    MerchantIdDTO findByIdAndStatus(String merchantId, String status);

    List<MerchantIdDTO> findAll();

    MerchantIdDTO update(MerchantIdDTO merchantIdDTO);

    boolean delete(String merchantId);

    List<MerchantIdDTO> findByStatus(String status);
}
