package com.lunchbox.customer.service.impl;

import com.lunchbox.common.errorfreamwork.exception.CustomerNotFoundException;
import com.lunchbox.customer.dto.MerchantDTO;
import com.lunchbox.customer.repository.MerchantIdRepository;
import com.lunchbox.customer.repository.entity.Merchant;
import com.lunchbox.customer.service.MerchantService;
import com.lunchbox.customer.service.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class MerchantIdServiceImpl implements MerchantService {
    @Autowired
    private MerchantIdRepository merchantIdRepository;

    @Override
    public Optional<MerchantDTO> findByMsisdn(String msisdn) {
        final Merchant merchantRepositoryByMsisdn = merchantIdRepository.findByMsisdn(msisdn);
        return Optional.ofNullable(MerchantMapper.getMerchantDTO(merchantRepositoryByMsisdn).orElseThrow(() -> new CustomerNotFoundException("Merchant %s Not found.", msisdn)));
    }

    @Override
    public Optional<MerchantDTO> save(MerchantDTO merchantDTO) {
        merchantDTO.setMerchantId(UUID.randomUUID().toString());
        merchantDTO.setStatus("S");
        merchantDTO.setCreationDate(LocalDateTime.now());
        merchantDTO.setLastUpdateDate(LocalDateTime.now());
        return MerchantMapper.getMerchantDTO(merchantIdRepository.save(MerchantMapper.getMerchantId(merchantDTO)));
    }

    @Override
    public Optional<MerchantDTO> findById(String merchantId) {
        final Merchant byId = merchantIdRepository.getById(merchantId);
      /*  if (isNull(byId)) {
            throw new CustomerNotFoundException("Merchant %s Not found.", merchantId);
        }*/
        return MerchantMapper.getMerchantDTO(byId);
    }

    @Override
    public Optional<MerchantDTO> findByIdAndStatus(String msisdn, String status) {
        return MerchantMapper.getMerchantDTO(merchantIdRepository.findByMsisdnAndStatus(msisdn, status));
    }

    @Override
    public List<MerchantDTO> findAll() {
        return MerchantMapper.listOfMerchant(merchantIdRepository.findAll());
    }

    @Override
    public Optional<MerchantDTO> update(MerchantDTO merchantDTO) {
        final Merchant merchantEntity = merchantIdRepository.getById(merchantDTO.getMerchantId());
        if (isNull(merchantEntity)) {
            throw new CustomerNotFoundException("Merchant %s Not found.", merchantDTO.getMsisdn());
        }
        merchantEntity.setUpdatedDate(LocalDateTime.now());
        merchantEntity.setLastUpdateDate(LocalDateTime.now());
        return MerchantMapper.getMerchantDTO(merchantIdRepository.save(MerchantMapper.merge(merchantEntity, merchantDTO)));
    }

    @Override
    public boolean delete(String merchantId) {

        final Merchant merchantEntity = merchantIdRepository.getById(merchantId);
        if (isNull(merchantEntity)) {
            throw new CustomerNotFoundException("Merchant %s Not found.", merchantId);
        }
        merchantEntity.setStatus("N");
        merchantEntity.setLastUpdateDate(LocalDateTime.now());
        merchantIdRepository.saveAndFlush(merchantEntity);

        return true;
    }

    @Override
    public List<MerchantDTO> findByStatus(String status) {
        return MerchantMapper.listOfMerchant(merchantIdRepository.findByStatus(status));
    }
}

