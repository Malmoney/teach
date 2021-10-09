package com.liurq.teacher.modules.system.entity;

import lombok.Data;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@Data
public class TeacherInfoRsp {

    private String teacherId;
    private String teacherName;
    private String phone;
    private String phone2;
    private String level;
    private String sex;
    private String age;

    private String classId;
    private String className;
}
