package com.liurq.teacher.modules.files.service;

import com.liurq.teacher.modules.files.entity.req.GetFilesListReq;
import com.liurq.teacher.modules.files.entity.rsp.GetFilesListRsp;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
public interface FilesAdminService {

    /**
     * 查询文件列表
     * @param req
     * @return
     */
    List<GetFilesListRsp> getFilesList(GetFilesListReq req);

}
