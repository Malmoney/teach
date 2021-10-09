package com.liurq.teacher.modules.system.service.impl;

import com.liurq.student.modules.files.mapper.TeacherMapper;
import com.liurq.teacher.modules.system.entity.TeacherInfoRsp;
import com.liurq.teacher.modules.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@Service
public class TeacherServiceeImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public TeacherInfoRsp getTeacherInfoById(String id) {
        return teacherMapper.getTeacherInfoById(id);
    }
}
