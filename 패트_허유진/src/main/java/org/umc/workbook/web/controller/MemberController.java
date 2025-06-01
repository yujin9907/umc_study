package org.umc.workbook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.umc.workbook.apiPayload.ApiResponse;
import org.umc.workbook.converter.MemberConverter;
import org.umc.workbook.domain.Member;
import org.umc.workbook.dto.MemberDto;
import org.umc.workbook.service.MemberService.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/")
    public ApiResponse<MemberDto.JoinResultDTO> join(@RequestBody @Valid MemberDto.JoinDto request){
        Member member = memberService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
