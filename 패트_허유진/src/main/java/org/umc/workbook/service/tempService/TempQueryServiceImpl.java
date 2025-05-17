package org.umc.workbook.service.tempService;

import org.springframework.stereotype.Service;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.handler.TempHandler;

@Service
public class TempQueryServiceImpl implements TempQueryService{
    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
