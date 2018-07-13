package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;

public class MorningPersonClassificationImpl implements  Classification {

    private final DataAccess fileDataAccess;

    public MorningPersonClassificationImpl(DataAccess dataAccess){
        this.fileDataAccess = dataAccess;
    }

    @Override
    public String getClassificationDescription() {
        return "Makes one or more withdrawals over $1000 in the month";
    }

    @Override
    public boolean isClassified(Long customerId, int month, int year) {


        long totalTxnsForTheMonth = fileDataAccess.getTransactionCount(customerId, month, year);
        long totalTxnsMadeBeforeMidDay = fileDataAccess.getCountofTransactionDoneBeforeAndOnMidDay(customerId, month, year);


        float percent = (totalTxnsMadeBeforeMidDay * 100.0f) / totalTxnsForTheMonth;
        if (percent > 50) {
            return true;
        }

        return false;
    }
}
