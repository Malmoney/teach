package com.liurq.student.modules.files.controller;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.entity.req.StudentClassReq;
import com.liurq.student.modules.files.entity.rsp.StudentRsp;
import com.liurq.student.modules.files.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/selectStudentListByName",method = {RequestMethod.POST,RequestMethod.GET})
    private RspInfo<List<StudentRsp>> selectStudentListByName(@RequestBody StudentClassReq req){
        return studentService.selectStudentListByName(req);
    }
}
