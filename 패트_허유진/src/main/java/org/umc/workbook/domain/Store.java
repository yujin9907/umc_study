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
@Table(name = "store")
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false)
    private int startTime;

    @Column(nullable = false)
    private int endTime;

    @Column(nullable = true)
    private Float score; // TODO 쓸지말지

    @ManyToOne(fetch = FetchType.LAZY)
    private StoreType type;

    @OneToMany(mappedBy = "store")
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Storeimage> iamges = new ArrayList<>();

}
