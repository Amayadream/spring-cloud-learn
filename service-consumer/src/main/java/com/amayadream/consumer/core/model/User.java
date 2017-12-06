package com.amayadream.consumer.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : xjding
 * @date :   2017-11-29 19:45
 */
@Data
@Builder
public class User implements Serializable {

    private Long id;
    private String userName;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

}
