package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;
import com.ingdirect.customerprofiler.dao.FileDataAccessImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MorningPersonClassificationImplTests {

    DataAccess fileDataAccess;
    Classification classification;

    @Before
    public void setUp(){
        fileDataAccess = new FileDataAccessImpl("data/testdata.txt");
        classification = new MorningPersonClassificationImpl(fileDataAccess);
    }

    @Test
    public void shouldReturnTrueWhenMeetsCriteria(){
        boolean isclassfied = classification.isClassified(56L,6,2016);
        Assert.assertTrue(isclassfied);
    }

    @Test
    public void shouldReturnFalseWhenDoNotMeetCriteria(){
        boolean isclassfied = classification.isClassified(57L,6,2016);
        Assert.assertTrue(!isclassfied);
    }
}
