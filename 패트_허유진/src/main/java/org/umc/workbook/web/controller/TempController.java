package org.umc.workbook.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.handler.TempHandler;
import org.umc.workbook.converter.TempConverter;
import org.umc.workbook.service.tempService.TempQueryService;
import org.umc.workbook.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempController {

    private final TempQueryService tempQueryService;

    @GetMapping("test")
    public ApiResponse<TempResponse.TempTestDto> testAPI() {

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }
    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam("flag") Integer flag){
        tempQueryService.checkFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
    @GetMapping("internal-exception")
    public ApiResponse<?> exception500API(){
        // _INTERNAL_SERVER_ERROR
        throw new TempHandler(ErrorStatus._INTERNAL_SERVER_ERROR);
    }
}
