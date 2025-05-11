package org.umc.workbook.service.MemberService;

import org.umc.workbook.domain.Member;

public interface MemberService {

    Member findById(Long memberId);
}
