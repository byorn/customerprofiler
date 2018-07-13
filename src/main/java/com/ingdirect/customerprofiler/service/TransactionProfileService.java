package com.ingdirect.customerprofiler.service;

import com.ingdirect.customerprofiler.dto.CustomerProfileDTO;

public interface TransactionProfileService {

    CustomerProfileDTO buildCustomerProfile(long customerId, String date);

}
