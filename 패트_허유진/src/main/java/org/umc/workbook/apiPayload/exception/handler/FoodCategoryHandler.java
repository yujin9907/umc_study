package org.umc.workbook.apiPayload.exception.handler;

import org.umc.workbook.apiPayload.BaseErrorCode;
import org.umc.workbook.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
