package com.econetwireless.epay.business.services.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.econetwireless.epay.dao.requestpartner.api.RequestPartnerDao;
import com.econetwireless.epay.domain.RequestPartner;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.execeptions.EpayException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PartnerCodeValidatorImplTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Method under test: default or parameterless constructor of {@link PartnerCodeValidatorImpl}
     */
    @Test
    public void testConstructor() {
        new PartnerCodeValidatorImpl(mock(RequestPartnerDao.class));
    }

    /**
     * Method under test: {@link PartnerCodeValidatorImpl#validatePartnerCode(String)}
     */
    @Test
    public void testValidatePartnerCode() {
        RequestPartner requestPartner = new RequestPartner();
        requestPartner.setCode("Code");
        requestPartner.setDescription("The characteristics of someone or something");
        requestPartner.setId(123L);
        requestPartner.setName("Name");
        RequestPartnerDao requestPartnerDao = mock(RequestPartnerDao.class);
        when(requestPartnerDao.findByCode((String) any())).thenReturn(requestPartner);
        assertTrue((new PartnerCodeValidatorImpl(requestPartnerDao)).validatePartnerCode("Partner Code"));
        verify(requestPartnerDao).findByCode((String) any());
    }

    /**
     * Method under test: {@link PartnerCodeValidatorImpl#validatePartnerCode(String)}
     */
    @Test
    public void testValidatePartnerCode2() {
        RequestPartnerDao requestPartnerDao = mock(RequestPartnerDao.class);
        when(requestPartnerDao.findByCode((String) any()))
                .thenThrow(new EpayException(ResponseCode.SUCCESS, "An error occurred"));
        thrown.expect(EpayException.class);
        (new PartnerCodeValidatorImpl(requestPartnerDao)).validatePartnerCode("Partner Code");
        verify(requestPartnerDao).findByCode((String) any());
    }
}

