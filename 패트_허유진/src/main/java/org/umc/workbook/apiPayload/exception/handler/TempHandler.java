package org.umc.workbook.apiPayload.exception.handler;

import org.umc.workbook.apiPayload.BaseErrorCode;
import org.umc.workbook.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}