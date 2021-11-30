package com.lunchbox.customer.merchant.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangePinDTO {
    private String walletNumber;
    private String msisdn;
    private String oldPin;
    private String newPin;
    private String confirmPin;
}
