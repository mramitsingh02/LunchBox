package com.lunchbox.customer.menucatalog.repository;

import com.lunchbox.customer.menucatalog.repository.entiy.MenuCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCatalogRepository extends JpaRepository<MenuCatalog, Long> {
    MenuCatalog findByMsisdn(String fromMsisdn);

    MenuCatalog findByMerchantId(String fromMsisdn);
}
