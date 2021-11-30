package com.lunchbox.customer.rattingservice.repository;

import com.lunchbox.customer.rattingservice.repository.entiy.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    //@Query(value = "select f from Feedback f where f.createdDate= ?0")
    List<Feedback> findByCreatedDate(LocalDate fromDate);

    //List<Feedback> findByFromDate(LocalDate fromDate, LocalDate toDate);

    List<Feedback> findByEmailId(String emailId);
}
