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
    private Long id;
    private String name;
    private String birth;
    private String photo;
    private String property;
    private Long mTId;
    private Long mCId;
}
