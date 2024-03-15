package com.dseoki.api.member;

import com.dseoki.api.entity.Member;
import com.dseoki.api.member.domain.MemberSignUpReq;
import com.dseoki.api.member.domain.MemberSignUpRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public MemberSignUpRes registMember(MemberSignUpReq memberReq) {
        Member member = repository.save(memberReq.toEntity());
        return MemberSignUpRes.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .build();
    }
}
