package org.umc.workbook.apiPayload.exception.handler;

import org.umc.workbook.apiPayload.BaseErrorCode;
import org.umc.workbook.apiPayload.exception.GeneralException;

public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode code) {
        super(code);
    }
}
