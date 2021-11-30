package com.lunchbox.customer.rattingservice.service.impl;

import com.lunchbox.customer.rattingservice.dto.FeedbackDTO;
import com.lunchbox.customer.rattingservice.repository.FeedbackRepository;
import com.lunchbox.customer.rattingservice.service.FeedbackService;
import com.lunchbox.customer.rattingservice.service.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackDTO createOrUpdate(FeedbackDTO feedbackDTO) {
        return FeedbackMapper.getFeedbackDTO(feedbackRepository.save(FeedbackMapper.getFeedback(feedbackDTO)));
    }

    @Override
    public List<FeedbackDTO> fetchAllFeedback() {
        return FeedbackMapper.listFeedbackDTO(feedbackRepository.findAll());
    }

    @Override
    public List<FeedbackDTO> fetchFeedback(LocalDate fromDate) {
        return FeedbackMapper.listFeedbackDTO(feedbackRepository.findByCreatedDate(fromDate));
    }

    @Override
    public List<FeedbackDTO> fetchFeedback(LocalDate fromDate, LocalDate toDate) {
        return FeedbackMapper.listFeedbackDTO(feedbackRepository.findByCreatedDate(fromDate));
    }

    @Override
    public List<FeedbackDTO> findByEmailId(String emailId) {
        return FeedbackMapper.listFeedbackDTO(feedbackRepository.findByEmailId(emailId));
    }
}
