package com.lunchbox.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantIdDTO {
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

    public MerchantIdDTO setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public MerchantIdDTO setStatus(String status) {
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
