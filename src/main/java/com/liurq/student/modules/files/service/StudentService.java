package com.liurq.student.modules.files.service;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.entity.req.StudentClassReq;
import com.liurq.student.modules.files.entity.rsp.StudentRsp;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
public interface StudentService {

    RspInfo<List<StudentRsp>> selectStudentListByName(StudentClassReq req);
}
