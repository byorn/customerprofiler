package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;

import java.util.List;

public interface DataAccess {
    List<FileData> loadData();
    List<FileData> getAllTxnsForCustomerMonthAndYear(Long customerId, int month, int year);
    long getTxnCountForCustomerMonthYearAndAfterMidDay(Long customerId, int month, int year);
    long getTxnCountForCustomerMonthYearAndBeforeMidDay(Long customerId, int month, int year);
    long getTxnCountForCustomerMonthAndYear(Long customerId, int month, int year);
    long getTxnCountForCustomerMonthAndYearWithExcessWithdrawalOver1000(Long customerId, int month, int year);
}
