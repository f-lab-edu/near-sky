package com.dseoki.api.member.domain;

import com.dseoki.api.entity.Member;
import lombok.Getter;

@Getter
public class MemberSignUpReq {
    private String name;
    private String nickname;
    private String password;
    private String birthday;
    private String mobile;
    private String email;
    private String region;
    private RoleType roleType;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .password(password)
                .birthday(birthday)
                .mobile(mobile)
                .email(email)
                .region(region)
                .roleType(roleType)
                .build();
    }
}
