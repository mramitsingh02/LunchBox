package com.lunchbox.customer.rattingservice.repository;

import com.lunchbox.customer.rattingservice.repository.entiy.Feedback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FeedbackRepositoryTest {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Test
    public void testSaveFeedback() {
        feedbackRepository.save(Feedback.builder().emailId("amit.singh@gmail.com").messages("Application is good").createdDate(LocalDate.now()).ratting(4).build());
    }

    @Test
    public void testGetFeedback() {

        final List<Feedback> byEmailId = feedbackRepository.findByEmailId("amit.singh@gmail.com");
        assertThat(byEmailId).isNotNull();

    }


}