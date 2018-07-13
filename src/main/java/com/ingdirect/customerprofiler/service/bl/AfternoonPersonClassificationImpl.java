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
    public boolean isClassified(int month, Long customerId) {

        long totalTxnsForTheMonth = fileDataAccess.getTxnCountForCustomerIDAndMonth(customerId,month);
        long totalTxnsMadeAfterMidDay = fileDataAccess.getTxnCountForCustomerIDAndMonthAndAfterMidDay(customerId,month);


        float percent = (totalTxnsMadeAfterMidDay * 100.0f) / totalTxnsForTheMonth;
        if(percent>50){
            return true;
        }

        return false;
    }
}
