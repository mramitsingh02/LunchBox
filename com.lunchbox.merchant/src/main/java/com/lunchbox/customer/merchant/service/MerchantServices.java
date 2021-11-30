package com.lunchbox.customer.merchant.service;

import com.lunchbox.customer.merchant.dto.MerchantDTO;

import java.util.List;

public interface MerchantServices {
    MerchantDTO findByMsisdn(String msisdn);

    MerchantDTO save(MerchantDTO merchantDTO);

    MerchantDTO findByMsisdnAndPin(String msisdn, String pin);

    List<MerchantDTO> findAll();

   // MerchantDTO changePin(String msisdn, ChangePinDTO changePin);

    MerchantDTO findByWalletNumber(String walletNumber);

    void deleteByWalletNumber(String walletNumber);

    void deleteByMsisdnAndPin(String msisdn, String pin);
}
