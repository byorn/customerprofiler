package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;

public class BigTicketSpenderClassificationImpl implements  Classification {

    private final DataAccess fileDataAccess;

    public BigTicketSpenderClassificationImpl(DataAccess dataAccess){
        this.fileDataAccess = dataAccess;
    }

    @Override
    public String getClassificationDescription() {
        return "Big Ticket Spender";
    }

    @Override
    public boolean isClassified(Long customerId, int month, int year) {

        long count = fileDataAccess.getTransactionCountHavingExcessWithdrawalOver1000(customerId,month,year);

        if(count > 0){
            return true;
        }

        return false;
    }
}
