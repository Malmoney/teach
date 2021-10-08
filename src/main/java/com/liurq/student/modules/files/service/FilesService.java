package com.liurq.student.modules.files.service;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.entity.req.AddFileReq;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
public interface FilesService {

    RspInfo<String> addFileRecord(AddFileReq req);
}
