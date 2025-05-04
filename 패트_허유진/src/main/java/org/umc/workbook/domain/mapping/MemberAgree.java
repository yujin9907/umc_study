package org.umc.workbook.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Terms;
import org.umc.workbook.domain.common.BaseEntity;
import org.umc.workbook.domain.enums.AgreeStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member_aggree")
public class MemberAgree extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AgreeStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Terms terms;
}