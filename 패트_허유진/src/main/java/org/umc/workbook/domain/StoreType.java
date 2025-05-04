package org.umc.workbook.domain;

import jakarta.persistence.*;
import lombok.*;
import org.umc.workbook.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "store_type")
public class StoreType extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 15)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory category;

    @OneToMany(mappedBy = "type")
    private List<Store> stores = new ArrayList<>();

}
