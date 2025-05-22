package com.web.board.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


@Schema(description = "게시판 항목 request")
public record BoardRequest(
    @Schema(description = "게시판 Id")
    Long boardId,

    @Schema(description = "제목")
    @NotBlank(message = "제목은 필수 입니다.")
    String title,

    @Schema(description = "내용")
    @NotBlank(message = "내용은 필수 입니다.")
    String content
) {
    public BoardRequest(String title, String content) {
        this(null, title, content); // boardId는 null로 설정
    }
}
