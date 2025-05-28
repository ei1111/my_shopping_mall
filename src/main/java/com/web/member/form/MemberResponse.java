package com.web.member.form;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 항목 response")
public record MemberResponse(
        @Schema(description = "회원 줄 번호", example = "1")
        int id,

        @Schema(description = "회원 이름", example = "홍길동")
        String name,

        @Schema(description = "거주도시", example = "서울")
        String city,

        @Schema(description = "도로명", example = "양갈로")
        String street,

        @Schema(description = "우편번호", example = "01321")
        String zipcode
        ) {
}
