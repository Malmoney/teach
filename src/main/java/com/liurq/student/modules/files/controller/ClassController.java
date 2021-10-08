package com.liurq.student.modules.files.controller;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.model.Clazz;
import com.liurq.student.modules.files.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@RestController
@RequestMapping(value = "/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/selectClassList",method = {RequestMethod.POST,RequestMethod.GET})
    public RspInfo<List<Clazz>> selectClassList(){
        return classService.selectClassList();
    }
}
