package com.liurq.student.modules.files.service.impl;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.entity.req.StudentClassReq;
import com.liurq.student.modules.files.entity.rsp.StudentRsp;
import com.liurq.student.modules.files.mapper.StudentMapper;
import com.liurq.student.modules.files.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public RspInfo<List<StudentRsp>> selectStudentListByName(StudentClassReq req) {
        List<StudentRsp> studentRsps = studentMapper.selectStudentListByName(req.getStudentName(),req.getClassId());
        return RspInfo.success(studentRsps);
    }
}
