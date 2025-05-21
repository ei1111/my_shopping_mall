package com.web.member.form;

import jakarta.validation.constraints.NotBlank;

public record MemberRequest(
         @NotBlank(message = "아름은 필수 항목입니다.") String name
        , @NotBlank(message = "도시는 필수 항목입니다.") String city
        , @NotBlank(message = "도로명은 필수 항목입니다.") String street
        , @NotBlank(message = "우편번호는 필수 항목입니다.") String zipcode) {

}
