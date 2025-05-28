package com.web.board.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boards")
public class BoardViewController {

    @GetMapping("/new")
    public String boardForm(@RequestParam(required = false) Long boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "board/boardForm";
    }

    @GetMapping
    public String boardList() {
        return "board/boardList";
    }
}
