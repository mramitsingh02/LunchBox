package com.lunchbox.customer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Builder
@Entity(name = "CUSTOMERS")
@Getter
@Table(name = "CUSTOMERS")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @Column(name = "customerId", nullable = false)
    private String customerId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String merchantId;
    private LocalDate dob;
    private String msisdn;
    private String pin;
    private String emailId;
    private String status;
    private String walletSpecId;
    private String walletId;
    @Embedded
    private Address address;

    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;
    private LocalDateTime lastUpdateDate;

    public Optional<Address> getAddressSafe() {
        return Optional.ofNullable(address);
    }
}

