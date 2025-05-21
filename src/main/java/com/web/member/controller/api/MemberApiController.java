package com.web.member.controller.api;

import com.web.board.form.BoardRequest;
import com.web.member.form.MemberRequest;
import com.web.member.form.MemberResponse;
import com.web.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/v1")
@Tag(name = "회원 API")
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/new")
    @Operation(summary = "회원 정보 등록 API")
    public void save(@Valid @RequestBody MemberRequest request) {
        memberService.save(request);
    }

    @GetMapping("/list")
    @Operation(summary = "회원 리스트 API")
    public ResponseEntity<List<MemberResponse>> memberList() {
        return ResponseEntity.ok(memberService.findAll());
    }
}
