package com.liurq.student.modules.files.entity.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@Data
public class StudentClassReq {
    @NotEmpty(message = "学生姓名不能为空")
    private String studentName;
    @NotEmpty(message = "班级信息不能为空")
    private String classId;
}
