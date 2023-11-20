package com.rara.app.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author itsmeyjc
 * @since 2021. 5. 6.
 */

@Getter
@Setter
public class FileDTO {
    private String uuid;    // unique 한 파일 이름을 만들기 위한 속성
    private String fileName;    // 실제 파일 이름
    private String contentType;

    public FileDTO() {
    }

    public FileDTO(String uuid, String fileName, String contentType) {
        this.uuid = uuid;
        this.fileName = fileName;
        this.contentType = contentType;
        System.out.println(contentType);
    }

    // setter/getter는 생략
}