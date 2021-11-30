package com.lunchbox.customer.rattingservice.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedbackDTO {
    private Long id;
    private String messages;
    private String emailId;
    private LocalDate createdDate;
    private int ratting;
}
