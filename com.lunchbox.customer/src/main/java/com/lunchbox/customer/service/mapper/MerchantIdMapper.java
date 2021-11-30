package com.lunchbox.customer.service.mapper;

import com.lunchbox.customer.dto.MerchantIdDTO;
import com.lunchbox.customer.repository.entity.MerchantId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MerchantIdMapper {
    public static MerchantId getMerchantId(MerchantIdDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return MerchantId.builder()
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

    public static MerchantIdDTO getMerchantIdDTO(MerchantId entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        return MerchantIdDTO.builder()
                .merchantId(entity.getMerchantId())
                .msisdn(entity.getMsisdn())
                .emailId(entity.getEmailId())
                .pin(entity.getPin())
                .status(entity.getStatus())
                .creationDate(entity.getCreationDate())
                .updatedDate(entity.getUpdatedDate())
                .lastUpdateDate(entity.getLastUpdateDate())
                .build();
    }

    public static List<MerchantIdDTO> getMerchantIdDTOs(List<MerchantId> all) {
        return all.stream().map(MerchantIdMapper::getMerchantIdDTO).collect(Collectors.toList());
    }

    public static MerchantId merge(MerchantId merchantEntity, MerchantIdDTO merchantIdDTO) {
        merchantEntity.setStatus(merchantIdDTO.getStatus());
        merchantEntity.setEmailId(merchantEntity.getEmailId());
        merchantEntity.setUpdatedDate(LocalDateTime.now());
        merchantEntity.setLastUpdateDate(LocalDateTime.now());
        return merchantEntity;
    }
}
