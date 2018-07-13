package com.ingdirect.customerprofiler.service;

import com.ingdirect.customerprofiler.dao.DataAccess;
import com.ingdirect.customerprofiler.dao.FileDataAccessImpl;
import com.ingdirect.customerprofiler.dto.CustomerProfileDTO;
import com.ingdirect.customerprofiler.dto.FileData;
import com.ingdirect.customerprofiler.service.bl.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.ingdirect.customerprofiler.util.Util.*;

@Service
public class TransactionProfileServiceImpl  implements TransactionProfileService{

    private final DataAccess dataAccess;

    public TransactionProfileServiceImpl(){
        dataAccess = new FileDataAccessImpl("data/testdata.txt");
    }


    @Override
    public CustomerProfileDTO buildCustomerProfile(long customerId, String date) {

        int month = parseDate(date).getMonthValue();
        int year = parseDate(date).getYear();

        List<FileData> transactions = dataAccess.getAllTransactions(customerId,month,year);

        BigDecimal balance = dataAccess.getCurrentBalance(customerId);

        Classification classification = getClassification(customerId,month,year);
        String classficationDescription = classification != null?classification.getClassificationDescription():"None";

        return new CustomerProfileDTO(balance.toString(),classficationDescription,transactions);
    }

    private Classification getClassification(Long customerId, int month, int year){
        List<Classification> classifications = new ArrayList<>();
        classifications.add(new AfternoonPersonClassificationImpl(dataAccess));
        classifications.add(new BigTicketSpenderClassificationImpl(dataAccess));
        classifications.add(new MorningPersonClassificationImpl(dataAccess));
        classifications.add(new PotentialSaverClassificationImpl(dataAccess));

        for(Classification classification: classifications){
            if(classification.isClassified(customerId,month,year)){
                return classification;
            }
        }
        return null;
    }

}
