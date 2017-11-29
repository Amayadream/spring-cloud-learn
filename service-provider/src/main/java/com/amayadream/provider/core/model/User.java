package com.amayadream.provider.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : xjding
 * @date :   2017-11-29 19:45
 */
@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

}
