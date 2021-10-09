package com.liurq.teacher.modules.files.controller;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.teacher.modules.files.entity.req.GetFilesListReq;
import com.liurq.teacher.modules.files.entity.rsp.GetFilesListRsp;
import com.liurq.teacher.modules.files.service.FilesAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@RestController
@RequestMapping("/teacher/files")
public class FilesAdminController {


    @Autowired
    private FilesAdminService filesAdminService;

    @RequestMapping(value = "/getFilesList",method = {RequestMethod.POST})
    public RspInfo getFilesList(@RequestBody @Valid GetFilesListReq req){
        ArrayList<GetFilesListRsp> result = (ArrayList)filesAdminService.getFilesList(req);
        return RspInfo.success(result);
    }

}
