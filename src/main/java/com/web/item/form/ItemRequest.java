package com.web.item.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "상품 항목 request")
public record ItemRequest(
        @Schema(description = "상품 이름")
        @NotBlank(message = "상품명은 필수 항목입니다.")
        String name,

        @Schema(description = "상품 가격")
        int price,

        @Schema(description = "상품 수량")
        int stockQuantity,

        @Schema(description = "상품 저자")
        String author,

        @Schema(description = "상품 isbn")
        String isbn
)
{
}
