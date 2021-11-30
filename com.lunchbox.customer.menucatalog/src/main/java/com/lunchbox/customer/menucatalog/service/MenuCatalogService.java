package com.lunchbox.customer.menucatalog.service;

import com.lunchbox.customer.menucatalog.dto.MerchantMenuCatalogDTO;
import com.lunchbox.customer.menucatalog.rest.MerchantMenuCatalogRequest;
import com.lunchbox.customer.menucatalog.rest.MerchantMenuCatalogResponse;

import java.util.List;

public interface MenuCatalogService {

    List<MerchantMenuCatalogDTO> fetchAllMenuCatalog();

    MerchantMenuCatalogResponse createOrUpdate(MerchantMenuCatalogRequest request);

}
