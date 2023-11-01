package com.rara.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id;

    private String title;
    private String content;
    private LocalDateTime created;
    private String category;
    private String file1;
    private String file2;
    private Long mId;
    private String author;
}
