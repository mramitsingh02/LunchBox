package com.lunchbox.customer.rattingservice.repository;

import com.lunchbox.customer.rattingservice.repository.entiy.ApplicationRatting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRattingRepository extends JpaRepository<ApplicationRatting, Long> {
    ApplicationRatting findByFromMsisdn(String fromMsisdn);
}
