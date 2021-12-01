package com.lunchbox.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO extends RepresentationModel<MerchantDTO> {
    private String merchantId;
    private String msisdn;
    private String pin;
    private String emailId;
    private String status;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    public MerchantDTO setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public MerchantDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}