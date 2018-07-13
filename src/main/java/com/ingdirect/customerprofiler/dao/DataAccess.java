package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface DataAccess {
    List<FileData> loadData();
    List<FileData> getAllTransactions(Long customerId, int month, int year);
    List<FileData> getDepositTransactions(Long customerId, int month, int year);
    BigDecimal getTotalExpenseAmountWithin7Days(Long customerId, int month, int year, LocalDateTime givenDate);
    long getCountofTransactionDoneAfterMidDay(Long customerId, int month, int year);
    long getCountofTransactionDoneBeforeAndOnMidDay(Long customerId, int month, int year);
    long getTransactionCount(Long customerId, int month, int year);
    long getTransactionCountHavingExcessWithdrawalOver1000(Long customerId, int month, int year);
    BigDecimal getTotalDepositAmount(Long customerId, int month, int year);
    BigDecimal getTotalExpenseAmount(Long customerId, int month, int year);
    BigDecimal getCurrentBalance(Long customerId);

}
