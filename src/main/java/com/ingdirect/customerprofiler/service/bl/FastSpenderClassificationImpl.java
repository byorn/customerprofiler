package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;
import com.ingdirect.customerprofiler.dto.FileData;

import java.math.BigDecimal;
import java.util.List;

public class FastSpenderClassificationImpl implements  Classification {

    private final DataAccess fileDataAccess;

    public FastSpenderClassificationImpl(DataAccess dataAccess){
        this.fileDataAccess = dataAccess;
    }

    @Override
    public String getClassificationDescription() {
        return "Makes over 50% of their transactions in the month after midday";
    }

    @Override
    public boolean isClassified(Long customerId, int month, int year) {

        List<FileData> fileDataList = fileDataAccess.getDepositTransactions(customerId,month,year);

        for(FileData fileData:fileDataList){
            BigDecimal depositAmount = fileData.getAmount();
            BigDecimal totalExpenseWithin7Days = fileDataAccess.getTotalExpenseAmountWithin7Days(customerId,month,year,fileData.getDate());

            BigDecimal percent = totalExpenseWithin7Days.abs().multiply(new BigDecimal(100)).divide(depositAmount);
            if (percent.floatValue() > 75) {
                return true;
            }
        }

        return false;
    }
}
