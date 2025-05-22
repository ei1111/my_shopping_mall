package com.web.board.form;

import com.web.board.domain.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Schema(description = "게시판 response")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardResponse {
    @Schema(name = "게시글 번호")
    public Long boardId;

    @Schema(name = "게시글 제목")
    public String title;

    @Schema(name = "게시글 내용")
    public String content;

    @Schema(name = "게시글 순서")
    public int rowNum;

    public BoardResponse(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }

    public static BoardResponse from(Board board) {
        return new BoardResponse(board.getBoardId(), board.getTitle(), board.getContent());
    }

    public void increaseRowNum(AtomicInteger index) {
        this.rowNum = index.getAndIncrement();
    }
}
