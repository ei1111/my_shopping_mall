package com.web.member.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "회원 항목")
public record MemberRequest(
        @Schema(description = "회원 이름")
        @NotBlank(message = "아름은 필수 항목입니다.")
        String name,

        @Schema(description = "거주도시")
        @NotBlank(message = "도시는 필수 항목입니다.")
        String city,

        @Schema(description = "도로명")
        @NotBlank(message = "도로명은 필수 항목입니다.")
        String street,

        @Schema(description = "우편번호")
        @NotBlank(message = "우편번호는 필수 항목입니다.")
        String zipcode
) {}
