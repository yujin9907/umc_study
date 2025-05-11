package org.umc.workbook.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umc.workbook.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
