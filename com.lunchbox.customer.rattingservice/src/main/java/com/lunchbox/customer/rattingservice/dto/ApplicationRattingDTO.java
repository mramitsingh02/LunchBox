package com.lunchbox.customer.rattingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApplicationRattingDTO extends RepresentationModel<ApplicationRattingDTO> {
    private Long rattingId;
    private String fromMsisdn;
    private float ratting;
    private String description;

}
