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
        dataAccess = new FileDataAccessImpl("data/data.txt");
    }


    @Override
    public CustomerProfileDTO buildCustomerProfile(long customerId, String date) {

        int month = parseDate(date).getMonthValue();
        int year = parseDate(date).getYear();

        List<FileData> transactions = dataAccess.getAllTransactions(customerId,month,year);

        BigDecimal balance = dataAccess.getCurrentBalance(customerId);

        String classification = getClassification(customerId,month,year);

        return new CustomerProfileDTO(balance.toString(),classification,transactions);
    }

    private String getClassification(Long customerId, int month, int year){

        StringBuilder classifications = new StringBuilder();

        List<Classification> rules = new ArrayList<>();
        rules.add(new AfternoonPersonClassificationImpl(dataAccess));
        rules.add(new BigTicketSpenderClassificationImpl(dataAccess));
        rules.add(new MorningPersonClassificationImpl(dataAccess));
        rules.add(new PotentialSaverClassificationImpl(dataAccess));
        rules.add(new FastSpenderClassificationImpl(dataAccess));
        rules.add(new BigSpenderClassificationImpl(dataAccess));

        boolean bigSpender = false;
        boolean fastSpender = false;

        for(Classification classification: rules){
            if(classification.isClassified(customerId,month,year)){
                if(classification instanceof BigSpenderClassificationImpl){
                    bigSpender = true;
                }
                if(classification instanceof FastSpenderClassificationImpl){
                    fastSpender = true;
                }
                classifications.append(classification.getClassificationDescription() + " / ");
            }
        }

        if(bigSpender && fastSpender){
            classifications.append("Potential Loan");
        }

        return classifications.toString();
    }

}
