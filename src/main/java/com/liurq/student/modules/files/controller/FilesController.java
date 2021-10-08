package com.liurq.student.modules.files.controller;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.entity.req.AddFileReq;
import com.liurq.student.modules.files.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@RestController
@RequestMapping(value = "/files")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @RequestMapping(value = "addFileRecord",method = {RequestMethod.POST})
    public RspInfo<String> addFileRecord(@RequestBody @Valid AddFileReq req){
        return filesService.addFileRecord(req);
    }


}
