package com.ingdirect.customerprofiler.controller;

import com.ingdirect.customerprofiler.dto.CustomerProfileDTO;
import com.ingdirect.customerprofiler.service.TransactionProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionProfileController {

    @Autowired
    TransactionProfileService transactionProfileService;

    @RequestMapping("/profile/{customerId}/{date}")
    public CustomerProfileDTO profile(@PathVariable("customerId")String customerId,@PathVariable("date")String date){
        return transactionProfileService.buildCustomerProfile(Long.parseLong(customerId),date);
    }
}
