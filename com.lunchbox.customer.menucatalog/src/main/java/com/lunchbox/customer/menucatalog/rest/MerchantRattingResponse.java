package com.lunchbox.customer.menucatalog.rest;

import com.lunchbox.customer.menucatalog.dto.CustomerRattingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Data
public class MerchantRattingResponse {
    private String merchantId;
    private String msisdn;
    private double averageRatting;
    private int numberOfRatting;
    private List<CustomerRattingDTO> rattings;
}
