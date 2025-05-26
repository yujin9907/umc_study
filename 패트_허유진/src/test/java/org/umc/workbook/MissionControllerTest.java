package org.umc.workbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.umc.workbook.domain.mapping.MemberMission;
import org.umc.workbook.service.MissionService.MissionService;
import org.umc.workbook.web.controller.MissionController;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureRestDocs
@WebMvcTest(MissionController.class)
class MissionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MissionService missionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("[GET] 특정 유저의 도전 미션 조회 API")
    void findMissionByMemberDocs() throws Exception {
        // given
        Long memberId = 1L;
        Integer reward = 500;
        LocalDateTime createdAt = LocalDateTime.of(2024, 5, 20, 15, 30, 0);
        Long missionId = 100L;

        List<MemberMission> mockResult = List.of();

        when(missionService.findMissionByMember(memberId, reward, createdAt, missionId))
                .thenReturn(mockResult);

        // when & then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/mission/member/{memberId}", memberId)
                        .param("reward", reward.toString())
                        .param("createdAt", "20240520153000")
                        .param("missionId", missionId.toString())
                        .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isOk())
                .andDo(print())
                .andDo(document("get-member-missions",
                        pathParameters(
                                parameterWithName("memberId").description("회원 ID")
                        ),
                        queryParameters(
                                parameterWithName("reward").description("기준 보상 커서"),
                                parameterWithName("createdAt").description("기준 생성일시 커서 (yyyyMMddHHmmss 형식)"),
                                parameterWithName("missionId").description("기준 미션 ID 커서")
                        ),
                        responseFields(
                                fieldWithPath("isSuccess").type(JsonFieldType.BOOLEAN).description("요청 성공 여부"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("응답 코드"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("응답 메시지"),
                                fieldWithPath("result").type(JsonFieldType.ARRAY).description("도전 중인 미션 리스트")
                        )
                ));
    }
}