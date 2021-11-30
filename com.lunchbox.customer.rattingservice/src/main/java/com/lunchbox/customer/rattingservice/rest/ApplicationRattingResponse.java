package com.lunchbox.customer.rattingservice.rest;

import com.lunchbox.customer.rattingservice.dto.ApplicationRattingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Data
public class ApplicationRattingResponse {
    private String name;
    private double averageRatting;
    private int numberOfRatting;
    private List<ApplicationRattingDTO> rattings;


    public static ApplicationRattingResponse.Builder newBuilder() {
        return new Builder();
    }


    public static class Builder {
        private final String name = "Lunchbox";
        private double averageRatting;
        private int numberOfRatting;
        private List<ApplicationRattingDTO> rattings;

        public Builder setRatting(List<ApplicationRattingDTO> rattings) {
            this.rattings = rattings;
            return this;
        }

        public ApplicationRattingResponse build() {
            averageRatting = rattings.stream()
                    .mapToDouble(ApplicationRattingDTO::getRatting)
                    .average().orElse(0d);

            numberOfRatting = rattings.size();
            return new ApplicationRattingResponse(name, averageRatting, numberOfRatting, rattings);
        }
    }
}
