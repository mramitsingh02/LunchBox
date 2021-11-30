package com.lunchbox.customer.menucatalog.rest;

import com.lunchbox.customer.menucatalog.dto.MenuCatalogDTO;

import java.util.List;

public class MerchantMenuCatalogRequest {
    private String merchantId;
    private String msisdn;
    private List<MenuCatalogDTO> lstOfMenuCatalog;


}
