package com.rara.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyRecordDTO {

    private Long id;
    private String title;
    private String content;
    private String file1;
    private String file2;
    private String act1Rec;
    private String act2Rec;
    private Long cId;
    private Long dpId;

}
