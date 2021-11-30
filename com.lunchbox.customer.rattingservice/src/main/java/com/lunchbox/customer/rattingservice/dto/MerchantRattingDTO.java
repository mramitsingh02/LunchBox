package com.lunchbox.customer.rattingservice.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class MerchantRattingDTO extends RepresentationModel<MerchantRattingDTO> {
    private Long rattingId;
    private String msisdn;
    private String customerId;
    private float ratting;
    private String description;

}
