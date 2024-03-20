package com.dseoki.api.member;

import com.dseoki.api.entity.Member;
import com.dseoki.api.member.domain.MemberSignUpReq;
import com.dseoki.api.member.domain.MemberSignUpRes;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    public String loadUserByUsername(String loginId, String loginPw) {
        if (loginId == null || loginPw == null) {
            return null;
        }

        String encPw = repository.findByEmail(loginId).orElse(null).getPassword();
//        if (passwordEncoder.matches(loginPw, encPw)) {
//            // 로그인 처리
//        }

        return null;
    }

    public MemberSignUpRes registMember(MemberSignUpReq memberReq) {
        Member member = repository.save(memberReq.toEntity(passwordEncoder));
        return MemberSignUpRes.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .build();
    }
}
