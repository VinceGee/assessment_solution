package com.econetwireless.epay.business.services.impl;

import com.econetwireless.epay.business.services.api.PartnerCodeValidator;
import com.econetwireless.epay.dao.requestpartner.api.RequestPartnerDao;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.execeptions.EpayException;

/**
 * Created by tnyamakura on 18/3/2017.
 */
public class PartnerCodeValidatorImpl implements PartnerCodeValidator{

    private RequestPartnerDao requestPartnerDao;

    public PartnerCodeValidatorImpl(RequestPartnerDao requestPartnerDao) {
        /**
         * With Java, when you use explicit call to super constructor. The keyword super() should be the first statement.
         * The is super keyword that may be used to access parent type values.
         * */
        super();
        this.requestPartnerDao = requestPartnerDao;
    }

    @Override
    public boolean validatePartnerCode(final String partnerCode) {
        final boolean isValidPartner = requestPartnerDao.findByCode(partnerCode) != null;
        if(!isValidPartner) {
            throw new EpayException(ResponseCode.INVALID_REQUEST, "Invalid partner code supplied : "+partnerCode);
        }
        return isValidPartner;
    }
}
