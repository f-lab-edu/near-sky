package com.dseoki.api.member.domain;

import com.dseoki.api.entity.Member;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class MemberSignUpReq {

    private String name;
    private String nickname;
    private String password;
    private String birthday;
    private String mobile;
    private String email;
    private String region;
    private RoleType roleType;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .email(email)
                .password(passwordEncoder.encode(password))
                .birthday(birthday)
                .mobile(mobile)
                .region(region)
                .roleType(RoleType.NORMAL)
                .build();
    }

    /**
     * 패스워드 암호화
     */
    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
