package org.umc.workbook.domain;

import jakarta.persistence.*;
import lombok.*;
import org.umc.workbook.domain.common.BaseEntity;
import org.umc.workbook.domain.enums.Gender;
import org.umc.workbook.domain.enums.MemberStatus;
import org.umc.workbook.domain.enums.SocialType;
import org.umc.workbook.domain.mapping.MemberAgree;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false, length = 50)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Column(nullable = false)
    private LocalDateTime inactiveDate;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(nullable = true, length = 50)
    private String email;

    @Column(nullable = false)
    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAgree> agreements = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberPrefer> preferences = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberMission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();
}
