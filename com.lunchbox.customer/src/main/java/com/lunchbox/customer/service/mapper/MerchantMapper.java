package com.lunchbox.customer.service.mapper;

import com.lunchbox.customer.dto.MerchantDTO;
import com.lunchbox.customer.repository.entity.Merchant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class MerchantMapper {
    public static Merchant getMerchantId(MerchantDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return Merchant.builder()
                .merchantId(dto.getMerchantId())
                .msisdn(dto.getMsisdn())
                .emailId(dto.getEmailId())
                .pin(dto.getPin())
                .status(dto.getStatus())
                .creationDate(dto.getCreationDate())
                .updatedDate(dto.getUpdatedDate())
                .lastUpdateDate(dto.getLastUpdateDate())
                .build();
    }

    public static Optional<MerchantDTO> getMerchantDTO(Merchant entity) {
        if (Objects.isNull(entity)) {
            return Optional.empty();
        }

        return Optional.ofNullable(MerchantDTO.builder()
                .merchantId(entity.getMerchantId())
                .msisdn(entity.getMsisdn())
                .emailId(entity.getEmailId())
                .pin(entity.getPin())
                .status(entity.getStatus())
                .creationDate(entity.getCreationDate())
                .updatedDate(entity.getUpdatedDate())
                .lastUpdateDate(entity.getLastUpdateDate())
                .build());
    }

    public static List<MerchantDTO> listOfMerchant(List<Merchant> all) {
        return all.stream().map(MerchantMapper::getMerchantDTO).map(Optional::get).collect(Collectors.toList());
    }

    public static Merchant merge(Merchant merchantEntity, MerchantDTO merchantDTO) {
        merchantEntity.setStatus(merchantDTO.getStatus());
        merchantEntity.setEmailId(merchantEntity.getEmailId());
        merchantEntity.setUpdatedDate(LocalDateTime.now());
        merchantEntity.setLastUpdateDate(LocalDateTime.now());
        return merchantEntity;
    }
}
