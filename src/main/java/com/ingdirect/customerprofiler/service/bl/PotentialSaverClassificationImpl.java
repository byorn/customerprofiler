package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;

import java.math.BigDecimal;

public class PotentialSaverClassificationImpl implements  Classification {

    private final DataAccess fileDataAccess;

    public PotentialSaverClassificationImpl(DataAccess dataAccess){
        this.fileDataAccess = dataAccess;
    }

    @Override
    public String getClassificationDescription() {
        return "Potential Saver";
    }

    @Override
    public boolean isClassified(Long customerId, int month, int year) {

        BigDecimal totalDeposit = fileDataAccess.getTotalDepositAmount(customerId, month, year);
        BigDecimal totalExpenses = fileDataAccess.getTotalExpenseAmount(customerId, month, year);

        if(totalDeposit.longValue()==0){
            return false;
        }

        BigDecimal percent = totalExpenses.abs().multiply(new BigDecimal(100)).divide(totalDeposit);
        if (percent.floatValue() < 25) {
            return true;
        }

        return false;
    }
}
