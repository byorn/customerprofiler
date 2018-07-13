package com.ingdirect.customerprofiler.service;

import com.ingdirect.customerprofiler.dto.CustomerProfileDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TransactionProfileServiceImplTests {

    private TransactionProfileService transactionProfileService;

    @Before
    public void setup(){
        transactionProfileService = new TransactionProfileServiceImpl();
    }

    @Test
    public void givenCustomerIDMonthAndYearWhenServiceCalledShouldReturnNoClassification(){
        //given
        Long customerId = 999L;
        String date = "2018-07-05";

        //when
        CustomerProfileDTO customerProfileDTO = transactionProfileService.buildCustomerProfile(customerId,date);

        //then
        Assert.assertEquals("No records found for the selected month",customerProfileDTO.getClassification());
    }
}
