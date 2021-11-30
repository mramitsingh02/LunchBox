package com.lunchbox.customer.menucatalog.dto;

import com.lunchbox.customer.menucatalog.rest.MerchantRattingResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Data
public class MerchantMenuCatalogDTO {
    private MerchantIdDTO merchant;
    private List<MenuCatalogDTO> listOfCatalog;
    private MerchantRattingResponse retting;
}
