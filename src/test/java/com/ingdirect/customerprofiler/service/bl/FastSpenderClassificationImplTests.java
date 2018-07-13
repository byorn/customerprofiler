package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;
import com.ingdirect.customerprofiler.dao.FileDataAccessImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FastSpenderClassificationImplTests {

    DataAccess fileDataAccess;
    Classification classification;

    @Before
    public void setUp(){
        fileDataAccess = new FileDataAccessImpl("data/testdata.txt");
        classification = new FastSpenderClassificationImpl(fileDataAccess);
    }

    @Test
    public void shouldReturnTrueWhenMeetsCriteria(){
        boolean isclassfied = classification.isClassified(90l,6,2016);
        Assert.assertTrue(isclassfied);
    }

    @Test
    public void shouldReturnFalseWhenDoesNotMeetCriteria(){
        boolean isclassfied = classification.isClassified(91L,6,2016);
        Assert.assertTrue(!isclassfied);
    }
}
