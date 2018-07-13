package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;

public class BigTicketSpenderClassificationImpl implements  Classification {

    private final DataAccess fileDataAccess;

    public BigTicketSpenderClassificationImpl(DataAccess dataAccess){
        this.fileDataAccess = dataAccess;
    }

    @Override
    public String getClassificationDescription() {
        return "Makes one or more withdrawals over $1000 in the month";
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
