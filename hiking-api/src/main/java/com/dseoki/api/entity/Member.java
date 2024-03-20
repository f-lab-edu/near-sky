package com.dseoki.api.entity;

import com.dseoki.api.member.domain.RoleType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String nickname;

    @Column(length = 50)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(length = 10)
    private String birthday;

    private Integer age;

    @Column(length = 13)
    private String mobile;

    private String region;

    @Column(length = 100)
    private String detailAddr;

    @Column(length = 50)
    private String numberAddr;

    private RoleType roleType;

}
