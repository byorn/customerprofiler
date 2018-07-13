package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;

public class AfternoonPersonClassificationImpl implements  Classification {

    private final DataAccess fileDataAccess;

    public AfternoonPersonClassificationImpl(DataAccess dataAccess){
        this.fileDataAccess = dataAccess;
    }

    @Override
    public String getClassificationDescription() {
        return "Makes over 50% of their transactions in the month after midday";
    }

    @Override
    public boolean isClassified(Long customerId, int month, int year) {

        long totalTxnsForTheMonth = fileDataAccess.getTxnCountForCustomerMonthAndYear(customerId, month, year);
        long totalTxnsMadeAfterMidDay = fileDataAccess.getTxnCountForCustomerMonthYearAndAfterMidDay(customerId, month, year);


        float percent = (totalTxnsMadeAfterMidDay * 100.0f) / totalTxnsForTheMonth;
        if (percent > 50) {
            return true;
        }

        return false;
    }
}
