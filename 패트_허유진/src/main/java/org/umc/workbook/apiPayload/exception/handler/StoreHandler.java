package org.umc.workbook.apiPayload.exception.handler;

import org.umc.workbook.apiPayload.BaseErrorCode;
import org.umc.workbook.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}
