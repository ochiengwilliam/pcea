package com.example.pcea.controller;

import com.example.pcea.entities.Member;
import com.example.pcea.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }


    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }


    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }
}
