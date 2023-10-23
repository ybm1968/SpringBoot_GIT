package com.joeun.springsecurity.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Users {
    private int userNo;
    private String userId;
    private String userPw;
    private String userPwCheck;     // 비밀번호 확인 (평문의 비밀번호, 암호화 X)
    private String name;
    private String email;
    private Date regDate;
    private Date updDate;
    private int enabled;            // 휴면여부

    // 권한 목록
    List<UserAuth> authList;

}
