package com.lunchbox.customer.rattingservice.service;

import com.lunchbox.customer.rattingservice.dto.FeedbackDTO;

import java.time.LocalDate;
import java.util.List;

public interface FeedbackService {
    FeedbackDTO createOrUpdate(FeedbackDTO feedbackDTO);

    List<FeedbackDTO> fetchAllFeedback();

    List<FeedbackDTO> fetchFeedback(LocalDate fromDate);

    List<FeedbackDTO> fetchFeedback(LocalDate fromDate, LocalDate toDate);

    List<FeedbackDTO> findByEmailId(String emailId);
}
