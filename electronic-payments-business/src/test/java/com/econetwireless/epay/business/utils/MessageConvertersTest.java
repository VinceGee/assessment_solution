package com.econetwireless.epay.business.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.econetwireless.in.webservice.BalanceResponse;
import com.econetwireless.in.webservice.CreditRequest;
import com.econetwireless.in.webservice.CreditResponse;
import com.econetwireless.utils.pojo.INBalanceResponse;
import com.econetwireless.utils.pojo.INCreditRequest;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.junit.Test;

public class MessageConvertersTest {
    /**
     * Method under test: {@link MessageConverters#convert(BalanceResponse)}
     */
    @Test
    public void testConvert() {
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setAmount(10.0d);
        balanceResponse.setMsisdn("42");
        balanceResponse.setNarrative("42");
        balanceResponse.setResponseCode("42");
        INBalanceResponse actualConvertResult = MessageConverters.convert(balanceResponse);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("42", actualConvertResult.getResponseCode());
        assertEquals("42", actualConvertResult.getNarrative());
        assertEquals("42", actualConvertResult.getMsisdn());
    }

    /**
     * Method under test: {@link MessageConverters#convert(BalanceResponse)}
     */
    @Test
    public void testConvert2() {
        BalanceResponse balanceResponse = mock(BalanceResponse.class);
        when(balanceResponse.getAmount()).thenReturn(10.0d);
        when(balanceResponse.getMsisdn()).thenReturn("Msisdn");
        when(balanceResponse.getNarrative()).thenReturn("Narrative");
        when(balanceResponse.getResponseCode()).thenReturn("Response Code");
        doNothing().when(balanceResponse).setAmount(anyDouble());
        doNothing().when(balanceResponse).setMsisdn((String) any());
        doNothing().when(balanceResponse).setNarrative((String) any());
        doNothing().when(balanceResponse).setResponseCode((String) any());
        balanceResponse.setAmount(10.0d);
        balanceResponse.setMsisdn("42");
        balanceResponse.setNarrative("42");
        balanceResponse.setResponseCode("42");
        INBalanceResponse actualConvertResult = MessageConverters.convert(balanceResponse);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("Response Code", actualConvertResult.getResponseCode());
        assertEquals("Narrative", actualConvertResult.getNarrative());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
        verify(balanceResponse).getAmount();
        verify(balanceResponse).getMsisdn();
        verify(balanceResponse).getNarrative();
        verify(balanceResponse).getResponseCode();
        verify(balanceResponse).setAmount(anyDouble());
        verify(balanceResponse).setMsisdn((String) any());
        verify(balanceResponse).setNarrative((String) any());
        verify(balanceResponse).setResponseCode((String) any());
    }

    /**
     * Method under test: {@link MessageConverters#convert(CreditRequest)}
     */
    @Test
    public void testConvert3() {
        CreditRequest creditRequest = new CreditRequest();
        creditRequest.setAmount(10.0d);
        creditRequest.setMsisdn("42");
        creditRequest.setPartnerCode("42");
        creditRequest.setReferenceNumber("42");
        INCreditRequest actualConvertResult = MessageConverters.convert(creditRequest);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("42", actualConvertResult.getReferenceNumber());
        assertEquals("42", actualConvertResult.getPartnerCode());
        assertEquals("42", actualConvertResult.getMsisdn());
    }

    /**
     * Method under test: {@link MessageConverters#convert(CreditRequest)}
     */
    @Test
    public void testConvert4() {
        CreditRequest creditRequest = mock(CreditRequest.class);
        when(creditRequest.getAmount()).thenReturn(10.0d);
        when(creditRequest.getMsisdn()).thenReturn("Msisdn");
        when(creditRequest.getPartnerCode()).thenReturn("Partner Code");
        when(creditRequest.getReferenceNumber()).thenReturn("42");
        doNothing().when(creditRequest).setAmount(anyDouble());
        doNothing().when(creditRequest).setMsisdn((String) any());
        doNothing().when(creditRequest).setPartnerCode((String) any());
        doNothing().when(creditRequest).setReferenceNumber((String) any());
        creditRequest.setAmount(10.0d);
        creditRequest.setMsisdn("42");
        creditRequest.setPartnerCode("42");
        creditRequest.setReferenceNumber("42");
        INCreditRequest actualConvertResult = MessageConverters.convert(creditRequest);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("42", actualConvertResult.getReferenceNumber());
        assertEquals("Partner Code", actualConvertResult.getPartnerCode());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
        verify(creditRequest).getAmount();
        verify(creditRequest).getMsisdn();
        verify(creditRequest).getPartnerCode();
        verify(creditRequest).getReferenceNumber();
        verify(creditRequest).setAmount(anyDouble());
        verify(creditRequest).setMsisdn((String) any());
        verify(creditRequest).setPartnerCode((String) any());
        verify(creditRequest).setReferenceNumber((String) any());
    }

    /**
     * Method under test: {@link MessageConverters#convert(CreditResponse)}
     */
    @Test
    public void testConvert5() {
        CreditResponse creditResponse = new CreditResponse();
        creditResponse.setBalance(10.0d);
        creditResponse.setMsisdn("42");
        creditResponse.setNarrative("42");
        creditResponse.setResponseCode("42");
        INCreditResponse actualConvertResult = MessageConverters.convert(creditResponse);
        assertEquals(10.0d, actualConvertResult.getBalance(), 0.0);
        assertEquals("42", actualConvertResult.getResponseCode());
        assertEquals("42", actualConvertResult.getNarrative());
        assertEquals("42", actualConvertResult.getMsisdn());
    }

    /**
     * Method under test: {@link MessageConverters#convert(CreditResponse)}
     */
    @Test
    public void testConvert6() {
        CreditResponse creditResponse = mock(CreditResponse.class);
        when(creditResponse.getBalance()).thenReturn(10.0d);
        when(creditResponse.getMsisdn()).thenReturn("Msisdn");
        when(creditResponse.getNarrative()).thenReturn("Narrative");
        when(creditResponse.getResponseCode()).thenReturn("Response Code");
        doNothing().when(creditResponse).setBalance(anyDouble());
        doNothing().when(creditResponse).setMsisdn((String) any());
        doNothing().when(creditResponse).setNarrative((String) any());
        doNothing().when(creditResponse).setResponseCode((String) any());
        creditResponse.setBalance(10.0d);
        creditResponse.setMsisdn("42");
        creditResponse.setNarrative("42");
        creditResponse.setResponseCode("42");
        INCreditResponse actualConvertResult = MessageConverters.convert(creditResponse);
        assertEquals(10.0d, actualConvertResult.getBalance(), 0.0);
        assertEquals("Response Code", actualConvertResult.getResponseCode());
        assertEquals("Narrative", actualConvertResult.getNarrative());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
        verify(creditResponse).getBalance();
        verify(creditResponse).getMsisdn();
        verify(creditResponse).getNarrative();
        verify(creditResponse).getResponseCode();
        verify(creditResponse).setBalance(anyDouble());
        verify(creditResponse).setMsisdn((String) any());
        verify(creditResponse).setNarrative((String) any());
        verify(creditResponse).setResponseCode((String) any());
    }

    /**
     * Method under test: {@link MessageConverters#convert(INBalanceResponse)}
     */
    @Test
    public void testConvert7() {
        INBalanceResponse inBalanceResponse = new INBalanceResponse();
        inBalanceResponse.setAmount(10.0d);
        inBalanceResponse.setMsisdn("Msisdn");
        inBalanceResponse.setNarrative("Narrative");
        inBalanceResponse.setResponseCode("Response Code");
        BalanceResponse actualConvertResult = MessageConverters.convert(inBalanceResponse);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("Response Code", actualConvertResult.getResponseCode());
        assertEquals("Narrative", actualConvertResult.getNarrative());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
    }

    /**
     * Method under test: {@link MessageConverters#convert(INBalanceResponse)}
     */
    @Test
    public void testConvert8() {
        INBalanceResponse inBalanceResponse = mock(INBalanceResponse.class);
        when(inBalanceResponse.getAmount()).thenReturn(10.0d);
        when(inBalanceResponse.getMsisdn()).thenReturn("Msisdn");
        when(inBalanceResponse.getNarrative()).thenReturn("Narrative");
        when(inBalanceResponse.getResponseCode()).thenReturn("Response Code");
        doNothing().when(inBalanceResponse).setAmount(anyDouble());
        doNothing().when(inBalanceResponse).setMsisdn((String) any());
        doNothing().when(inBalanceResponse).setNarrative((String) any());
        doNothing().when(inBalanceResponse).setResponseCode((String) any());
        inBalanceResponse.setAmount(10.0d);
        inBalanceResponse.setMsisdn("Msisdn");
        inBalanceResponse.setNarrative("Narrative");
        inBalanceResponse.setResponseCode("Response Code");
        BalanceResponse actualConvertResult = MessageConverters.convert(inBalanceResponse);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("Response Code", actualConvertResult.getResponseCode());
        assertEquals("Narrative", actualConvertResult.getNarrative());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
        verify(inBalanceResponse).getAmount();
        verify(inBalanceResponse).getMsisdn();
        verify(inBalanceResponse).getNarrative();
        verify(inBalanceResponse).getResponseCode();
        verify(inBalanceResponse).setAmount(anyDouble());
        verify(inBalanceResponse).setMsisdn((String) any());
        verify(inBalanceResponse).setNarrative((String) any());
        verify(inBalanceResponse).setResponseCode((String) any());
    }

    /**
     * Method under test: {@link MessageConverters#convert(INCreditRequest)}
     */
    @Test
    public void testConvert9() {
        INCreditRequest inCreditRequest = new INCreditRequest();
        inCreditRequest.setAmount(10.0d);
        inCreditRequest.setMsisdn("Msisdn");
        inCreditRequest.setPartnerCode("Partner Code");
        inCreditRequest.setReferenceNumber("42");
        CreditRequest actualConvertResult = MessageConverters.convert(inCreditRequest);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("42", actualConvertResult.getReferenceNumber());
        assertEquals("Partner Code", actualConvertResult.getPartnerCode());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
    }

    /**
     * Method under test: {@link MessageConverters#convert(INCreditRequest)}
     */
    @Test
    public void testConvert10() {
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
        CreditRequest actualConvertResult = MessageConverters.convert(inCreditRequest);
        assertEquals(10.0d, actualConvertResult.getAmount(), 0.0);
        assertEquals("42", actualConvertResult.getReferenceNumber());
        assertEquals("Partner Code", actualConvertResult.getPartnerCode());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
        verify(inCreditRequest).getAmount();
        verify(inCreditRequest).getMsisdn();
        verify(inCreditRequest).getPartnerCode();
        verify(inCreditRequest).getReferenceNumber();
        verify(inCreditRequest).setAmount(anyDouble());
        verify(inCreditRequest).setMsisdn((String) any());
        verify(inCreditRequest).setPartnerCode((String) any());
        verify(inCreditRequest).setReferenceNumber((String) any());
    }

    /**
     * Method under test: {@link MessageConverters#convert(INCreditResponse)}
     */
    @Test
    public void testConvert11() {
        INCreditResponse inCreditResponse = new INCreditResponse();
        inCreditResponse.setBalance(10.0d);
        inCreditResponse.setMsisdn("Msisdn");
        inCreditResponse.setNarrative("Narrative");
        inCreditResponse.setResponseCode("Response Code");
        CreditResponse actualConvertResult = MessageConverters.convert(inCreditResponse);
        assertEquals(10.0d, actualConvertResult.getBalance(), 0.0);
        assertEquals("Response Code", actualConvertResult.getResponseCode());
        assertEquals("Narrative", actualConvertResult.getNarrative());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
    }

    /**
     * Method under test: {@link MessageConverters#convert(INCreditResponse)}
     */
    @Test
    public void testConvert12() {
        INCreditResponse inCreditResponse = mock(INCreditResponse.class);
        when(inCreditResponse.getBalance()).thenReturn(10.0d);
        when(inCreditResponse.getMsisdn()).thenReturn("Msisdn");
        when(inCreditResponse.getNarrative()).thenReturn("Narrative");
        when(inCreditResponse.getResponseCode()).thenReturn("Response Code");
        doNothing().when(inCreditResponse).setBalance(anyDouble());
        doNothing().when(inCreditResponse).setMsisdn((String) any());
        doNothing().when(inCreditResponse).setNarrative((String) any());
        doNothing().when(inCreditResponse).setResponseCode((String) any());
        inCreditResponse.setBalance(10.0d);
        inCreditResponse.setMsisdn("Msisdn");
        inCreditResponse.setNarrative("Narrative");
        inCreditResponse.setResponseCode("Response Code");
        CreditResponse actualConvertResult = MessageConverters.convert(inCreditResponse);
        assertEquals(10.0d, actualConvertResult.getBalance(), 0.0);
        assertEquals("Response Code", actualConvertResult.getResponseCode());
        assertEquals("Narrative", actualConvertResult.getNarrative());
        assertEquals("Msisdn", actualConvertResult.getMsisdn());
        verify(inCreditResponse).getBalance();
        verify(inCreditResponse).getMsisdn();
        verify(inCreditResponse).getNarrative();
        verify(inCreditResponse).getResponseCode();
        verify(inCreditResponse).setBalance(anyDouble());
        verify(inCreditResponse).setMsisdn((String) any());
        verify(inCreditResponse).setNarrative((String) any());
        verify(inCreditResponse).setResponseCode((String) any());
    }
}

