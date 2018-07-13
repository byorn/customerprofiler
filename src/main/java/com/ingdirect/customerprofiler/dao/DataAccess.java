package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;

import java.math.BigDecimal;
import java.util.List;

public interface DataAccess {
    List<FileData> loadData();
    List<FileData> getAllTransactions(Long customerId, int month, int year);
    long getCountofTransactionDoneAfterMidDay(Long customerId, int month, int year);
    long getCountofTransactionDoneBeforeAndOnMidDay(Long customerId, int month, int year);
    long getTransactionCount(Long customerId, int month, int year);
    long getTransactionCountHavingExcessWithdrawalOver1000(Long customerId, int month, int year);
    BigDecimal getTotalDepositAmount(Long customerId, int month, int year);
    BigDecimal getTotalExpenseAmount(Long customerId, int month, int year);
    BigDecimal getCurrentBalance(Long customerId);

}
