package com.liurq.teacher.modules.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author:hyz
 * @Date:2021-07-29
 * @Desc:
 **/
@Data
public class User {

    private String username;

    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private Date birthday;

}
