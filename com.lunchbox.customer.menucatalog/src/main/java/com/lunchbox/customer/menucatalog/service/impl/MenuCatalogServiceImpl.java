package com.lunchbox.customer.menucatalog.service.impl;

import com.lunchbox.customer.menucatalog.dto.MenuCatalogDTO;
import com.lunchbox.customer.menucatalog.dto.MerchantIdDTO;
import com.lunchbox.customer.menucatalog.dto.MerchantMenuCatalogDTO;
import com.lunchbox.customer.menucatalog.repository.MenuCatalogRepository;
import com.lunchbox.customer.menucatalog.repository.entiy.MenuCatalog;
import com.lunchbox.customer.menucatalog.rest.MerchantMenuCatalogRequest;
import com.lunchbox.customer.menucatalog.rest.MerchantMenuCatalogResponse;
import com.lunchbox.customer.menucatalog.rest.MerchantRattingResponse;
import com.lunchbox.customer.menucatalog.service.MenuCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MenuCatalogServiceImpl implements MenuCatalogService {

    @Autowired
    private MenuCatalogRepository menuCatalogRepository;

    @Override
    public List<MerchantMenuCatalogDTO> fetchAllMenuCatalog() {
        List<MerchantMenuCatalogDTO> list = new ArrayList<>();
        List<MerchantIdDTO> listOfMerchant = fetchAllMerchant();
        for (MerchantIdDTO eachMerchant : listOfMerchant) {
            List<MenuCatalogDTO> listOfMenuCatalogsForMerchant = fetchMenuCatalogForMerchant(eachMerchant);
            MerchantRattingResponse customerRattingDTO = fetchMerchantRatting(eachMerchant);
            list.add(MerchantMenuCatalogDTO.builder().merchant(eachMerchant)
                    .listOfCatalog(listOfMenuCatalogsForMerchant)
                    .retting(customerRattingDTO)
                    .build());

        }
        return list;
    }

    private MerchantRattingResponse fetchMerchantRatting(MerchantIdDTO eachMerchant) {
        String uri = "http://localhost:2020/merchant/ratting/msisdn/{msisdn}";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriParamMap = new HashMap<>();
        uriParamMap.put("msisdn", eachMerchant.getMsisdn());
        ResponseEntity<MerchantRattingResponse> allActiveMerchant = restTemplate.getForEntity(uri, MerchantRattingResponse.class, uriParamMap);

        if (allActiveMerchant.hasBody()) {
            return allActiveMerchant.getBody();
        }

        return null;
    }

    @Override
    public MerchantMenuCatalogResponse createOrUpdate(MerchantMenuCatalogRequest request) {
        return null;
    }

    private List<MenuCatalogDTO> fetchMenuCatalogForMerchant(MerchantIdDTO eachMerchant) {

        final MenuCatalog byFromMsisdn = menuCatalogRepository.findByMsisdn(eachMerchant.getMsisdn());

        return Collections.emptyList();
    }

    private List<MerchantIdDTO> fetchAllMerchant() {

        String uri = "http://localhost:9090/merchant/status/{status}";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriParamMap = new HashMap<>();
        uriParamMap.put("status", "Y");
        ResponseEntity<List<MerchantIdDTO>> allActiveMerchant = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }, uriParamMap);


        if (allActiveMerchant.hasBody()) {
            return allActiveMerchant.getBody();
        }


        return Collections.emptyList();
    }
}
