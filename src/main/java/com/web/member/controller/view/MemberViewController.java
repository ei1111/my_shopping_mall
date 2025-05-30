package com.web.member.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberViewController {

    @GetMapping("/new")
    public String form() {
        return "members/createMemberForm";
    }

    @GetMapping
    public String list() {
        return "members/memberList";
    }

}
