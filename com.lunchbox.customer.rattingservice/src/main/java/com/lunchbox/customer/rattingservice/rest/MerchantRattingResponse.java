package com.lunchbox.customer.rattingservice.rest;

import com.lunchbox.customer.rattingservice.dto.CustomerRattingDTO;
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


    public static MerchantRattingResponse.Builder newBuilder() {
        return new Builder();
    }


    public static class Builder {
        private String merchantId;
        private String msisdn;
        private double averageRatting;
        private int numberOfRatting;
        private List<CustomerRattingDTO> rattings;


        public Builder setRatting(List<CustomerRattingDTO> rattings) {
            this.rattings = rattings;
            return this;
        }

        public MerchantRattingResponse build() {
            averageRatting = rattings.stream()
                    .mapToDouble(CustomerRattingDTO::getRatting)
                    .average().orElse(0d);
            merchantId = rattings.stream()
                    .map(CustomerRattingDTO::getToCustomerId)
                    .findFirst().orElse("NA");
            msisdn = rattings.stream()
                    .map(CustomerRattingDTO::getToMsisdn)
                    .findFirst().orElse("NA");
            numberOfRatting = rattings.size();
            return new MerchantRattingResponse(merchantId, msisdn, averageRatting, numberOfRatting, rattings);
        }
    }
}
