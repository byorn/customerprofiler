package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class FileDataAccessImplTests {

    DataAccess fileDataAccess;

    @Before
    public void setUp(){
        fileDataAccess = new FileDataAccessImpl("data/testdata.txt");
    }


    @Test
    public void shouldReturnDataFromFile(){
        List<FileData> fileData = fileDataAccess.loadData();
        Assert.assertTrue(fileData.size()>0);
    }

    @Test
    public void shouldReturnDataForCustomerIDAndMonth(){
        List<FileData> fileData = fileDataAccess.getAllTxnsForCustomerMonthAndYear(23L,6,2016);

        Assert.assertTrue(fileData.size()==2);
    }

    @Test
    public void shouldReturnCountForCustomerIDAndMonthAndTimeAfterMidday(){
        long count = fileDataAccess.getTxnCountForCustomerMonthYearAndAfterMidDay(23L,6,2016);

        Assert.assertTrue(count==1);
    }

    @Test
    public void shouldReturnOneRecordForCustomerWithExcessWithdrawal(){
        long count = fileDataAccess.getTxnCountForCustomerMonthAndYearWithExcessWithdrawalOver1000(44L,7,2016);

        Assert.assertTrue(count==1);
    }

    @Test
    public void shouldReturnOneRecordForCustomerMonthYearAndTxnTimeBeforeMidDay(){
        long count = fileDataAccess.getTxnCountForCustomerMonthYearAndBeforeMidDay(55L,6,2016);

        Assert.assertTrue(count==2);
    }

    @Test
    public void shouldMatchExactData(){
        List<FileData> list = fileDataAccess.loadData();
        FileData fileData = list.stream().findFirst().get();
        Assert.assertEquals(3L,fileData.getCustomerId().longValue());
        Assert.assertEquals(2016,fileData.getDate().getYear());
        Assert.assertEquals(05,fileData.getDate().getMonth().getValue());
        Assert.assertEquals(9,fileData.getDate().getDayOfMonth());
        Assert.assertEquals(BigDecimal.valueOf(-13.94),fileData.getAmount());
        Assert.assertEquals("SIT MAURIS IPSUM SIT",fileData.getDescription());
    }
}
