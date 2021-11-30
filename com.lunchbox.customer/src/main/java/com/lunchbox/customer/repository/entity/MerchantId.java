package com.lunchbox.customer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
@Entity(name = "MerchantId")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantId implements Serializable {
    @Id
    @Column(name = "merchantId", nullable = false)
    private String merchantId;
    private String msisdn;
    private String pin;
    private String emailId;
    private String status;
    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;
    private LocalDateTime lastUpdateDate;


    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}

