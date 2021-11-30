package com.lunchbox.customer.menucatalog.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class CustomerRattingDTO extends RepresentationModel<CustomerRattingDTO> {
    private Long rattingId;
    private String fromMsisdn;
    private String fromCustomerId;
    private String toMsisdn;
    private String toCustomerId;
    private float ratting;
    private String description;

}
