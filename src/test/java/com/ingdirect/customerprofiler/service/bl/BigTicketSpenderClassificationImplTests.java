package com.ingdirect.customerprofiler.service.bl;

import com.ingdirect.customerprofiler.dao.DataAccess;
import com.ingdirect.customerprofiler.dao.FileDataAccessImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BigTicketSpenderClassificationImplTests {

    DataAccess fileDataAccess;
    Classification classification;

    @Before
    public void setUp() {
        fileDataAccess = new FileDataAccessImpl("data/testdata.txt");
        classification = new BigTicketSpenderClassificationImpl(fileDataAccess);
    }

    @Test
    public void shouldReturnTrueWhenMeetsCriteria() {
        boolean isclassfied = classification.isClassified(44L, 7, 2016);
        Assert.assertTrue(isclassfied);
    }

    @Test
    public void shouldReturnFalseWhenDoneNotMeetCriteria() {
        boolean isclassfied = classification.isClassified(44L, 8, 2016);
        Assert.assertTrue(!isclassfied);
    }
}
