package org.umc.workbook.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.umc.workbook.domain.FoodCategory;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member_prefer")
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private FoodCategory category;
}
