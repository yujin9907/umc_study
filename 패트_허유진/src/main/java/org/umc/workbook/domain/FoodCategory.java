package org.umc.workbook.domain;

import jakarta.persistence.*;
import lombok.*;
import org.umc.workbook.domain.common.BaseEntity;
import org.umc.workbook.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "food_category")
public class FoodCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<MemberPrefer> preferences = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<StoreType> storeTypes = new ArrayList<>();

}