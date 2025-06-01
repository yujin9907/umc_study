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
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory category;

    public void setMember(Member member){
        if(this.member != null)
            member.getPreferences().remove(this);
        this.member = member;
        member.getPreferences().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.category = foodCategory;
    }
}
