package com.econetwireless.epay.business.services.impl;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReportingServiceImplTest {
    /**
     * Method under test: default or parameterless constructor of {@link ReportingServiceImpl}
     */
    @Test
    public void testConstructor() {
        new ReportingServiceImpl(mock(SubscriberRequestDao.class));
    }

    /**
     * Method under test: {@link ReportingServiceImpl#findSubscriberRequestsByPartnerCode(String)}
     */
    @Test
    public void testFindSubscriberRequestsByPartnerCode() {
        SubscriberRequestDao subscriberRequestDao = mock(SubscriberRequestDao.class);
        ArrayList<SubscriberRequest> subscriberRequestList = new ArrayList<>();
        when(subscriberRequestDao.findByPartnerCode((String) any())).thenReturn(subscriberRequestList);
        List<SubscriberRequest> actualFindSubscriberRequestsByPartnerCodeResult = (new ReportingServiceImpl(
                subscriberRequestDao)).findSubscriberRequestsByPartnerCode("Partner Code");
        assertSame(subscriberRequestList, actualFindSubscriberRequestsByPartnerCodeResult);
        assertTrue(actualFindSubscriberRequestsByPartnerCodeResult.isEmpty());
        verify(subscriberRequestDao).findByPartnerCode((String) any());
    }
}

