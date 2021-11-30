package com.lunchbox.customer.service.impl;

import com.lunchbox.customer.dto.MerchantIdDTO;
import com.lunchbox.customer.exception.CustomerNotFoundException;
import com.lunchbox.customer.repository.MerchantIdRepository;
import com.lunchbox.customer.repository.entity.MerchantId;
import com.lunchbox.customer.service.MerchantIdService;
import com.lunchbox.customer.service.mapper.MerchantIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class MerchantIdServiceImpl implements MerchantIdService {
    @Autowired
    private MerchantIdRepository merchantIdRepository;

    @Override
    public MerchantIdDTO findByMsisdn(String msisdn) {
        final MerchantId merchantIdRepositoryByMsisdn = merchantIdRepository.findByMsisdn(msisdn);
        if (isNull(merchantIdRepositoryByMsisdn)) {
            throw new CustomerNotFoundException("Merchant %s Not found.", msisdn);
        }
        return MerchantIdMapper.getMerchantIdDTO(merchantIdRepositoryByMsisdn);
    }

    @Override
    public MerchantIdDTO save(MerchantIdDTO merchantIdDTO) {
        merchantIdDTO.setMerchantId(UUID.randomUUID().toString());
        merchantIdDTO.setStatus("S");
        merchantIdDTO.setCreationDate(LocalDateTime.now());
        merchantIdDTO.setLastUpdateDate(LocalDateTime.now());
        return MerchantIdMapper.getMerchantIdDTO(merchantIdRepository.save(MerchantIdMapper.getMerchantId(merchantIdDTO)));
    }

    @Override
    public MerchantIdDTO findById(String merchantId) {
        final MerchantId byId = merchantIdRepository.getById(merchantId);
        if (isNull(byId)) {
            throw new CustomerNotFoundException("Merchant %s Not found.", merchantId);
        }
        return MerchantIdMapper.getMerchantIdDTO(byId);
    }

    @Override
    public MerchantIdDTO findByIdAndStatus(String msisdn, String status) {
        return MerchantIdMapper.getMerchantIdDTO(merchantIdRepository.findByMsisdnAndStatus(msisdn, status));
    }

    @Override
    public List<MerchantIdDTO> findAll() {
        return MerchantIdMapper.getMerchantIdDTOs(merchantIdRepository.findAll());
    }

    @Override
    public MerchantIdDTO update(MerchantIdDTO merchantIdDTO) {
        final MerchantId merchantEntity = merchantIdRepository.getById(merchantIdDTO.getMerchantId());
        if (isNull(merchantEntity)) {
            throw new CustomerNotFoundException("Merchant %s Not found.", merchantIdDTO.getMsisdn());
        }
        merchantEntity.setUpdatedDate(LocalDateTime.now());
        merchantEntity.setLastUpdateDate(LocalDateTime.now());
        return MerchantIdMapper.getMerchantIdDTO(merchantIdRepository.save(MerchantIdMapper.merge(merchantEntity, merchantIdDTO)));
    }

    @Override
    public boolean delete(String merchantId) {

        final MerchantId merchantEntity = merchantIdRepository.getById(merchantId);
        if (isNull(merchantEntity)) {
            throw new CustomerNotFoundException("Merchant %s Not found.", merchantId);
        }
        merchantEntity.setStatus("N");
        merchantEntity.setLastUpdateDate(LocalDateTime.now());
        merchantIdRepository.saveAndFlush(merchantEntity);

        return true;
    }

    @Override
    public List<MerchantIdDTO> findByStatus(String status) {
        return MerchantIdMapper.getMerchantIdDTOs(merchantIdRepository.findByStatus(status));
    }
}

