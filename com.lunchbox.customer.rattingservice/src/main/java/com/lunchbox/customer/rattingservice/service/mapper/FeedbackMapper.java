package com.lunchbox.customer.rattingservice.service.mapper;

import com.lunchbox.customer.rattingservice.dto.FeedbackDTO;
import com.lunchbox.customer.rattingservice.repository.entiy.Feedback;

import java.util.List;
import java.util.stream.Collectors;

public class FeedbackMapper {
    public static Feedback getFeedback(FeedbackDTO feedbackDTO) {
        return null;
    }

    public static FeedbackDTO getFeedbackDTO(Feedback feedback) {
        return null;
    }

    public static List<FeedbackDTO> listFeedbackDTO(List<Feedback> all) {
        return all.stream().map(FeedbackMapper::getFeedbackDTO).collect(Collectors.toList());
    }
}
