package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;
import com.ingdirect.customerprofiler.dao.FileDataAccessImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AfternoonPersonClassificationImplTests {

    DataAccess fileDataAccess;
    Classification classification;

    @Before
    public void setUp(){
        fileDataAccess = new FileDataAccessImpl("data/testdata.txt");
        classification = new AfternoonPersonClassificationImpl(fileDataAccess);
    }

    @Test
    public void shouldReturnTrueWhenMeetsCriteria(){
        boolean isclassfied = classification.isClassified(6,33L);
        Assert.assertTrue(isclassfied);
    }
}
