package com.dseoki.api.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberSignUpRes {

    private Long id;
    private String nickname;

}
