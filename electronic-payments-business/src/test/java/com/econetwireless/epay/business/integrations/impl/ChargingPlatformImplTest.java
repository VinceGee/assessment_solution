package com.econetwireless.epay.business.integrations.impl;

import com.econetwireless.in.webservice.BalanceResponse;
import com.econetwireless.in.webservice.CreditResponse;
import com.econetwireless.in.webservice.IntelligentNetworkService;
import com.econetwireless.utils.pojo.INBalanceResponse;
import com.econetwireless.utils.pojo.INCreditRequest;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ChargingPlatformImplTest {

    /**
     * Method under test: {@link ChargingPlatformImpl#enquireBalance(String, String)}
     */
    @Test
    public void testEnquireBalance() {
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setAmount(10.0d);
        balanceResponse.setMsisdn("42");
        balanceResponse.setNarrative("42");
        balanceResponse.setResponseCode("42");
        IntelligentNetworkService intelligentNetworkService = mock(IntelligentNetworkService.class);
        when(intelligentNetworkService.enquireBalance((String) any(), (String) any())).thenReturn(balanceResponse);
        INBalanceResponse actualEnquireBalanceResult = (new ChargingPlatformImpl(intelligentNetworkService))
                .enquireBalance("Partner Code", "Msisdn");
        assertEquals(10.0d, actualEnquireBalanceResult.getAmount(), 0.0);
        assertEquals("42", actualEnquireBalanceResult.getResponseCode());
        assertEquals("42", actualEnquireBalanceResult.getNarrative());
        assertEquals("42", actualEnquireBalanceResult.getMsisdn());
        verify(intelligentNetworkService).enquireBalance((String) any(), (String) any());
    }

    /**
     * Method under test: {@link ChargingPlatformImpl#creditSubscriberAccount(INCreditRequest)}
     */
    @Test
    public void testCreditSubscriberAccount() {
        CreditResponse creditResponse = new CreditResponse();
        creditResponse.setBalance(10.0d);
        creditResponse.setMsisdn("42");
        creditResponse.setNarrative("42");
        creditResponse.setResponseCode("42");
        IntelligentNetworkService intelligentNetworkService = mock(IntelligentNetworkService.class);
        when(intelligentNetworkService.creditSubscriberAccount((com.econetwireless.in.webservice.CreditRequest) any()))
                .thenReturn(creditResponse);
        ChargingPlatformImpl chargingPlatformImpl = new ChargingPlatformImpl(intelligentNetworkService);
        INCreditRequest inCreditRequest = mock(INCreditRequest.class);
        when(inCreditRequest.getAmount()).thenReturn(10.0d);
        when(inCreditRequest.getMsisdn()).thenReturn("Msisdn");
        when(inCreditRequest.getPartnerCode()).thenReturn("Partner Code");
        when(inCreditRequest.getReferenceNumber()).thenReturn("42");
        doNothing().when(inCreditRequest).setAmount(anyDouble());
        doNothing().when(inCreditRequest).setMsisdn((String) any());
        doNothing().when(inCreditRequest).setPartnerCode((String) any());
        doNothing().when(inCreditRequest).setReferenceNumber((String) any());
        inCreditRequest.setAmount(10.0d);
        inCreditRequest.setMsisdn("Msisdn");
        inCreditRequest.setPartnerCode("Partner Code");
        inCreditRequest.setReferenceNumber("42");
        INCreditResponse actualCreditSubscriberAccountResult = chargingPlatformImpl
                .creditSubscriberAccount(inCreditRequest);
        assertEquals(10.0d, actualCreditSubscriberAccountResult.getBalance(), 0.0);
        assertEquals("42", actualCreditSubscriberAccountResult.getResponseCode());
        assertEquals("42", actualCreditSubscriberAccountResult.getNarrative());
        assertEquals("42", actualCreditSubscriberAccountResult.getMsisdn());
        verify(intelligentNetworkService).creditSubscriberAccount((com.econetwireless.in.webservice.CreditRequest) any());
        verify(inCreditRequest).getAmount();
        verify(inCreditRequest).getMsisdn();
        verify(inCreditRequest).getPartnerCode();
        verify(inCreditRequest).getReferenceNumber();
        verify(inCreditRequest).setAmount(anyDouble());
        verify(inCreditRequest).setMsisdn((String) any());
        verify(inCreditRequest).setPartnerCode((String) any());
        verify(inCreditRequest).setReferenceNumber((String) any());
    }
}

