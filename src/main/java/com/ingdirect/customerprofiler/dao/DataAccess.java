package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;

import java.util.List;

public interface DataAccess {
    List<FileData> loadData();
    List<FileData> searchByCustomerIDAndMonth(Long customerId,int month);
    long getTxnCountForCustomerIDAndMonthAndAfterMidDay(Long customerId, int month);
    long getTxnCountForCustomerIDAndMonth(Long customerId, int month);
}
