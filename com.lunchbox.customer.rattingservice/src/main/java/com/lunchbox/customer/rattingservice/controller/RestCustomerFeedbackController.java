package com.lunchbox.customer.rattingservice.controller;

import com.lunchbox.customer.rattingservice.dto.FeedbackDTO;
import com.lunchbox.customer.rattingservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController(value = "customerFeedbackService")
public class RestCustomerFeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(path = "/feedback")
    public FeedbackDTO sendFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        return feedbackService.createOrUpdate(feedbackDTO);
    }

    @PutMapping(path = "/feedback")
    public FeedbackDTO replyFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        return feedbackService.createOrUpdate(feedbackDTO);
    }

    @GetMapping(path = "/feedback/emailId/{emailId}")
    public List<FeedbackDTO> allCustomerRatting(@PathVariable String emailId) {
        List<FeedbackDTO> list = feedbackService.findByEmailId(emailId);
        return list;
    }

    @GetMapping(path = "/feedback/all")
    public List<FeedbackDTO> allFeedbacks() {
        return feedbackService.fetchAllFeedback();
    }

    @GetMapping(path = "/feedback/from/{fromDate}/to/{toDate}")
    public List<FeedbackDTO> fetchAllFeedback(@PathVariable(required = true) LocalDate fromDate, @PathVariable(required = false) LocalDate toDate) {
        List<FeedbackDTO> feedbackDTOS = null;
        if (Objects.nonNull(fromDate) && Objects.isNull(toDate)) {
            feedbackDTOS = feedbackService.fetchFeedback(fromDate);
        } else {
            feedbackDTOS = feedbackService.fetchFeedback(fromDate, toDate);
        }
        return feedbackDTOS;
    }


}
