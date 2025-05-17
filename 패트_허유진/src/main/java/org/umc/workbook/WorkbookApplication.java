package org.umc.workbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.umc.workbook.service.MemberService.MemberService;
import org.umc.workbook.service.MissionService.MissionService;

import java.time.LocalDateTime;

@EnableJpaAuditing
@SpringBootApplication
public class WorkbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkbookApplication.class, args);
    }
//
//    @Bean
//    public CommandLineRunner run(ApplicationContext context) {
//        return args -> {
////            StoreQueryService storeService = context.getBean(StoreQueryService.class);
////
////            // 파라미터 값 설정
////            String name = "요아정";
////            Float score = 4.0f;
////
////            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
////            System.out.println("Executing findStoresByNameAndScore with parameters:");
////            System.out.println("Name: " + name);
////            System.out.println("Score: " + score);
////
////            storeService.findStoresByNameAndScore(name, score)
////                    .forEach(System.out::println);
//
//            // 진행중 미션 쿼리 테스트
//            System.out.println("진행 중 미션 쿼리 테스트");
//            MissionService missionService = context.getBean(MissionService.class);
//
//            Long memberId = 1L;
//            Integer lastReward = 100;
//            LocalDateTime lastCreatedAt = LocalDateTime.now();
//            Long lastMissionId = 1L;
//
//            missionService.findMissionByMember(memberId, lastReward, lastCreatedAt, lastMissionId);
//
//            // 홈 화면
//            System.out.println("홈 화면 테스트");
//            Long lastMissionId2 = 1L;
//            Long memberId2 = 1L;
//            missionService.findHomeMission(lastMissionId2, memberId2);
//
//            // 마이페이지
//            System.out.println("마이페이지 조회 테스트");
//            Long memberId3 = 1L;
//            MemberService memberService = context.getBean(MemberService.class);
//            memberService.findById(memberId3);
//        };
//    }
//
}
