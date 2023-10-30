package com.rara.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyPlanDTO {

    private Long id;
    private Long year;
    private Long month;
    private Long day;
    private String key1;
    private String key2;
    private String key3;
    private String file1;
    private String file2;
    private String act1Type;
    private String act2Type;
    private String act1Goal;
    private String act2Goal;
    private Long act1Time;
    private Long act2Time;
    private String act1Title;
    private String act2Title;
    private String act1Sub;
    private String act2Sub;
    private String act1Desc;
    private String act2Desc;
    private String act1Mater;
    private String act2Mater;
    private Long mId;

}
