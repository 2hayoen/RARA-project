package com.rara.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String email;
    private String pwd;
    private String name;
    private String phNum;
    private String addr;


    // 보호자 서브 타입
    private String emerNum;

    // 교사 서브 타입
    private String class_;
    private String center;
    private String position;
    private Long mId;

    // 구분자
    private String separator;
}
