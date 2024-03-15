package com.dseoki.api.member.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class MemberSignUpRes {

    private Long id;
    private String nickname;

}
