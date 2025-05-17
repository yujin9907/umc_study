package org.umc.workbook.converter;

import org.umc.workbook.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDto toTempTestDTO(){
        return TempResponse.TempTestDto.builder()
                .testString("This is Test!")
                .build();
    }
    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
