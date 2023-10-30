package com.rara.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorialDTO {
    private Long id; // NUMBER(10)
    private String title; // VARCHAR2(255)
    private String description; // VARCHAR2(255)
    private Integer published; // NUMBER(1)
}

