package com.lunchbox.customer.merchant.service.impl;

import com.lunchbox.customer.merchant.dto.MerchantDTO;
import com.lunchbox.customer.merchant.persistance.MerchantRepository;
import com.lunchbox.customer.merchant.service.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MerchantServicesImpl implements MerchantServices {
    @Autowired
    private MerchantRepository merchantRepository;


    @Override
    public MerchantDTO findByMsisdn(String msisdn) {
        return null;
    }

    @Override
    public MerchantDTO save(MerchantDTO merchantDTO) {
        return null;
    }

    @Override
    public MerchantDTO findByMsisdnAndPin(String msisdn, String pin) {
        return null;
    }

    @Override
    public List<MerchantDTO> findAll() {
        return null;
    }

    @Override
    public MerchantDTO findByWalletNumber(String walletNumber) {
        return null;
    }

    @Override
    public void deleteByWalletNumber(String walletNumber) {

    }

    @Override
    public void deleteByMsisdnAndPin(String msisdn, String pin) {

    }
}
