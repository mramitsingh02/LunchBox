package com.lunchbox.customer.rattingservice.service.impl;

import com.lunchbox.customer.rattingservice.dto.ApplicationRattingDTO;
import com.lunchbox.customer.rattingservice.dto.CustomerRattingDTO;
import com.lunchbox.customer.rattingservice.repository.ApplicationRattingRepository;
import com.lunchbox.customer.rattingservice.repository.CustomerRattingRepository;
import com.lunchbox.customer.rattingservice.rest.MerchantRattingResponse;
import com.lunchbox.customer.rattingservice.service.RattingService;
import com.lunchbox.customer.rattingservice.service.mapper.RattingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class RattingServiceImpl implements RattingService {
    @Autowired
    private ApplicationRattingRepository applicationRattingRepository;

    @Autowired
    private CustomerRattingRepository customerRattingRepository;

    @Override
    public ApplicationRattingDTO createOrUpdateRatting(ApplicationRattingDTO applicationRattingDTO) {

        final ApplicationRattingDTO existingCustomerRatting = this.getApplicationRattingByFromMsisdn(applicationRattingDTO.getFromMsisdn());
        if (nonNull(existingCustomerRatting)) {
            if (applicationRattingDTO.getRatting() > existingCustomerRatting.getRatting()) {
                existingCustomerRatting.setRatting(applicationRattingDTO.getRatting());
            }
            existingCustomerRatting.setDescription(existingCustomerRatting.getDescription());
            return this.save(existingCustomerRatting);

        } else {
            return this.save(applicationRattingDTO);
        }
    }

    @Override
    public List<ApplicationRattingDTO> getApplicationRatting() {
        return RattingMapper.getApplicationRatting(applicationRattingRepository.findAll());
    }

    @Override
    public List<CustomerRattingDTO> getCustomerRatting() {
        return RattingMapper.getCustomerRattingDTO(customerRattingRepository.findAll());
    }

    @Override
    public CustomerRattingDTO getCustomerRatting(String msisdn) {
        return RattingMapper.getCustomerRattingDTO(customerRattingRepository.findByFromMsisdn(msisdn));
    }

    @Override
    public CustomerRattingDTO save(CustomerRattingDTO customerRattingDTO) {
        return RattingMapper.getCustomerRattingDTO(customerRattingRepository.save(RattingMapper.getCustomerRatting(customerRattingDTO)));
    }

    @Override
    public ApplicationRattingDTO save(ApplicationRattingDTO applicationRattingDTO) {
        return RattingMapper.getApplicationRattingDTO(applicationRattingRepository.saveAndFlush(RattingMapper.getApplicationRatting(applicationRattingDTO)));
    }

    @Override
    public ApplicationRattingDTO getApplicationRattingByFromMsisdn(String fromMsisdn) {
        return RattingMapper.getApplicationRattingDTO(applicationRattingRepository.findByFromMsisdn(fromMsisdn));
    }

    @Override
    public CustomerRattingDTO getCustomerRattingFromMsisdn(String fromMsisdn) {
        return RattingMapper.getCustomerRattingDTO(customerRattingRepository.findByFromMsisdn(fromMsisdn));
    }

    @Override
    public MerchantRattingResponse getMerchantRattingByMsisdn(String msisdn) {
        final List<CustomerRattingDTO> customersRatting = RattingMapper.getCustomerRattingDTO(customerRattingRepository.findByToMsisdn(msisdn));

        return MerchantRattingResponse.newBuilder().setRatting(customersRatting).build();

    }

    @Override
    public CustomerRattingDTO createOrUpdateRatting(CustomerRattingDTO customerRattingDTO) {

        final CustomerRattingDTO existingCustomerRatting = this.getCustomerRattingFromMsisdn(customerRattingDTO.getFromMsisdn());
        if (nonNull(existingCustomerRatting)) {
            if (existingCustomerRatting.getRatting() > existingCustomerRatting.getRatting()) {
                existingCustomerRatting.setRatting(existingCustomerRatting.getRatting());
            }
            existingCustomerRatting.setDescription(existingCustomerRatting.getDescription());
            return this.save(existingCustomerRatting);

        } else {
            return this.save(customerRattingDTO);
        }
    }
}
