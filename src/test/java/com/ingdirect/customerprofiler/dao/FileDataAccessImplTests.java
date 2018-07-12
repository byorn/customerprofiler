package com.ingdirect.customerprofiler.dao;

import com.ingdirect.customerprofiler.dto.FileData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDataAccessImplTests {

    @Autowired
    FileDataAccessImpl fileDataAccess;

    @Test
    public void shouldReturnDataFromFile(){
        List<FileData> fileData = fileDataAccess.loadData();
        Assert.assertTrue(fileData.size()>0);
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
