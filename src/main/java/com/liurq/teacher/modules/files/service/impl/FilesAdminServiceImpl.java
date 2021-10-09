package com.liurq.teacher.modules.files.service.impl;

import com.liurq.teacher.modules.files.entity.req.GetFilesListReq;
import com.liurq.teacher.modules.files.entity.rsp.GetFilesListRsp;
import com.liurq.teacher.modules.files.mapper.FileRecordAdminMapper;
import com.liurq.teacher.modules.files.mapper.SysConfigMapper;
import com.liurq.teacher.modules.files.model.SysConfig;
import com.liurq.teacher.modules.files.service.FilesAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@Service
public class FilesAdminServiceImpl implements FilesAdminService {

    @Autowired
    private FileRecordAdminMapper fileRecordAdminMapper;
    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 查询文件列表
     *
     * @param req
     * @return
     */
    @Override
    public List<GetFilesListRsp> getFilesList(GetFilesListReq req) {
        SysConfig sysConfig = sysConfigMapper.selectById("ALI_OSS_URL_PREFIX");
        return fileRecordAdminMapper.getFilesList(req.getClassId(),req.getEventId(),sysConfig.getConfigValue());
    }
}
