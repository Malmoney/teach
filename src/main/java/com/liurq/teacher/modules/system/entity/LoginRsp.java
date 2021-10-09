package com.liurq.teacher.modules.system.entity;

import lombok.Data;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@Data
public class LoginRsp {

    private TeacherInfoRsp teacherInfo;
    private String token;
}
