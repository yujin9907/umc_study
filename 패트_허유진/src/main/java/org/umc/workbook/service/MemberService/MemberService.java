package org.umc.workbook.service.MemberService;

import org.umc.workbook.domain.Member;
import org.umc.workbook.dto.MemberDto;

public interface MemberService {

    Member findById(Long memberId);
    public Member joinMember(MemberDto.JoinDto request);
}
