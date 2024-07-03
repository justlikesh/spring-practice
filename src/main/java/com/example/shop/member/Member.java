package com.example.shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity       // 클래스 만들고 @Entity를 붙이면 테이블생성
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//하나씩 증가

    private Long id;

    @Column(unique = true) //Column = 제약조건 (중복제거)
    private String username;
    private String displayName;
    private String password;
}
