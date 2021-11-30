package com.lunchbox.customer.menucatalog.controller;

import com.lunchbox.customer.menucatalog.dto.MerchantMenuCatalogDTO;
import com.lunchbox.customer.menucatalog.rest.MerchantMenuCatalogRequest;
import com.lunchbox.customer.menucatalog.rest.MerchantMenuCatalogResponse;
import com.lunchbox.customer.menucatalog.service.MenuCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "merchantMenuCatalogService")
public class RestMerchantMenuCatalogController {
    @Autowired
    private MenuCatalogService menuCatalogService;

    @PostMapping(path = "/merchant/menuCatalog/merchantId/{merchantId}")
    public MerchantMenuCatalogResponse createMenuCatalogForMerchant(@PathVariable String merchantId, @RequestBody MerchantMenuCatalogRequest request) {
        return menuCatalogService.createOrUpdate(request);
    }
/*
    @PutMapping(path = "/menuCatalog")
    public MenuCatalogDTO replyMenuCatalog(@RequestBody MenuCatalogDTO menuCatalogDTO) {
        return menuCatalogService.createOrUpdate(menuCatalogDTO);
    }

    @GetMapping(path = "/menuCatalog/emailId/{emailId}")
    public List<MenuCatalogDTO> allCustomerRatting(@PathVariable String emailId) {
        List<MenuCatalogDTO> list = menuCatalogService.findByEmailId(emailId);
        return list;
    }*/

    @GetMapping(path = "/merchant/menuCatalog/all")
    public List<MerchantMenuCatalogDTO> allMenuCatalogs() {
        return menuCatalogService.fetchAllMenuCatalog();
    }

/*
    @GetMapping(path = "/menuCatalog/from/{fromDate}/to/{toDate}")
    public List<MenuCatalogDTO> fetchAllMenuCatalog(@PathVariable(required = true) LocalDate fromDate, @PathVariable(required = false) LocalDate toDate) {
        List<MenuCatalogDTO> menuCatalogDTOS = null;
        if (Objects.nonNull(fromDate) && Objects.isNull(toDate)) {
            menuCatalogDTOS = menuCatalogService.fetchMenuCatalog(fromDate);
        } else {
            menuCatalogDTOS = menuCatalogService.fetchMenuCatalog(fromDate, toDate);
        }
        return menuCatalogDTOS;
    }
*/


}
