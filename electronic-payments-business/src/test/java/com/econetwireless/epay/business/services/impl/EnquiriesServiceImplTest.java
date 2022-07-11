package com.econetwireless.epay.business.services.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.econetwireless.epay.business.integrations.api.ChargingPlatform;
import com.econetwireless.epay.business.integrations.impl.ChargingPlatformImpl;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.utils.pojo.INBalanceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

public class EnquiriesServiceImplTest {
    /**
     * Method under test: default or parameterless constructor of {@link EnquiriesServiceImpl}
     */
    @Test
    public void testConstructor() {

        new EnquiriesServiceImpl(new ChargingPlatformImpl(null), mock(SubscriberRequestDao.class));

    }


    /**
     * Method under test: {@link EnquiriesServiceImpl#enquire(String, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEnquire() {

        INBalanceResponse inBalanceResponse = new INBalanceResponse();
        inBalanceResponse.setAmount(10.0d);
        inBalanceResponse.setMsisdn("Msisdn");
        inBalanceResponse.setNarrative("Narrative");
        inBalanceResponse.setResponseCode("Response Code");
        ChargingPlatform chargingPlatform = mock(ChargingPlatform.class);
        when(chargingPlatform.enquireBalance((String) any(), (String) any())).thenReturn(inBalanceResponse);

        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setAmount(10.0d);
        subscriberRequest.setBalanceAfter(10.0d);
        subscriberRequest.setBalanceBefore(10.0d);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        subscriberRequest.setDateCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        subscriberRequest.setDateLastUpdated(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        subscriberRequest.setId(123L);
        subscriberRequest.setMsisdn("Msisdn");
        subscriberRequest.setPartnerCode("Partner Code");
        subscriberRequest.setReference("Reference");
        subscriberRequest.setRequestType("Request Type");
        subscriberRequest.setStatus("Status");
        subscriberRequest.setVersion(1L);
        SubscriberRequestDao subscriberRequestDao = mock(SubscriberRequestDao.class);
        when(subscriberRequestDao.save((SubscriberRequest) any())).thenReturn(subscriberRequest);
        (new EnquiriesServiceImpl(chargingPlatform, subscriberRequestDao)).enquire("Partner Code", "Msisdn");
    }
}

