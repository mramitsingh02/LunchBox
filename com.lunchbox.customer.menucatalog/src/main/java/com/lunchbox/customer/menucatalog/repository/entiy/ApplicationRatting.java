package com.lunchbox.customer.menucatalog.repository.entiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "application_ratting", uniqueConstraints = {@UniqueConstraint(name = "msisdn", columnNames = {"fromMsisdn"})})
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
public class ApplicationRatting {
    @Id
    @GeneratedValue
    private Long rattingId;

    private String fromMsisdn;
    private float ratting;
    private String description;

}
