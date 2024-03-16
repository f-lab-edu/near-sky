package com.dseoki.api.member;

import com.dseoki.api.member.domain.MemberSignUpReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService service;

    /**
     * 회원 가입
     */
    @PostMapping("/regist")
    public ResponseEntity registMember(@RequestBody MemberSignUpReq memberDto) {
        return new ResponseEntity(service.registMember(memberDto), HttpStatus.OK);
    }
}
