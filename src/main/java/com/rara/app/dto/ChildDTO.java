package com.rara.app.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO {
    private Long id;            // NUMBER(10)
    private String name;        // VARCHAR2(50 CHAR)
    private String birth;       // VARCHAR2(50 CHAR)
    private String photo;       // VARCHAR2(255 BYTE)
    private String property;    // VARCHAR2(500 CHAR)

    private Long m_t_id;        // NUMBER(10)
    private Long m_c_id;        // NUMBER(10)
}