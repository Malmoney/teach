package com.liurq.student.modules.files.service.impl;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.mapper.ClazzMapper;
import com.liurq.student.modules.files.model.Clazz;
import com.liurq.student.modules.files.model.ClazzExample;
import com.liurq.student.modules.files.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public RspInfo<List<Clazz>> selectClassList() {
        ClazzExample clazzExample = new ClazzExample();
        clazzExample.createCriteria()
                .andDeletedEqualTo("0");
        List<Clazz> clazzes = clazzMapper.selectByExample(clazzExample);
        return RspInfo.success(clazzes);
    }
}
