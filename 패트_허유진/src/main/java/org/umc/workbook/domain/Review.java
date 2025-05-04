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
@Table(name = "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Lob
    private String body;

    @Column(nullable = false)
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review")
    private List<ReviewImage> images = new ArrayList<>();
}
