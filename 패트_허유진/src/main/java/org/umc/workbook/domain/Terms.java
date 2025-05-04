package org.umc.workbook.domain;

import jakarta.persistence.*;
import lombok.*;
import org.umc.workbook.domain.common.BaseEntity;
import org.umc.workbook.domain.mapping.MemberAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "terms")
public class Terms extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = true)
    @Lob
    private String body;

    @Column(nullable = false)
    private boolean optional;

    @OneToMany(mappedBy = "terms")
    private List<MemberAgree> agreements = new ArrayList<>();
}