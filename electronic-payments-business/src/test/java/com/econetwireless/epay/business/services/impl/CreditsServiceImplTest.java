package com.econetwireless.epay.business.services.impl;

import com.econetwireless.epay.business.integrations.impl.ChargingPlatformImpl;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.utils.messages.AirtimeTopupRequest;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.mockito.Mockito.*;

public class CreditsServiceImplTest {
    /**
     * Method under test: default or parameterless constructor of {@link CreditsServiceImpl}
     */
    @Test
    public void testConstructor() {
        new CreditsServiceImpl(new ChargingPlatformImpl(null), mock(SubscriberRequestDao.class));

    }

    /**
     * Method under test: {@link CreditsServiceImpl#credit(AirtimeTopupRequest)}
     */
    @Test
    @Ignore("TODO: Not complete")
    public void testCredit() {

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
        CreditsServiceImpl creditsServiceImpl = new CreditsServiceImpl(new ChargingPlatformImpl(null),
                subscriberRequestDao);

        AirtimeTopupRequest airtimeTopupRequest = new AirtimeTopupRequest();
        airtimeTopupRequest.setAmount(10.0d);
        airtimeTopupRequest.setMsisdn("Msisdn");
        airtimeTopupRequest.setPartnerCode("Partner Code");
        airtimeTopupRequest.setReferenceNumber("42");
        creditsServiceImpl.credit(airtimeTopupRequest);
    }

}

