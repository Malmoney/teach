package com.liurq.teacher.modules.system.service;

import com.liurq.teacher.modules.system.entity.TeacherInfoRsp;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
public interface TeacherService {

    TeacherInfoRsp getTeacherInfoById(String id);
}
