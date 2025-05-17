package org.umc.workbook.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.umc.workbook.apiPayload.BaseErrorCode;
import org.umc.workbook.apiPayload.ErrorReasonDto;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDto getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDto getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}