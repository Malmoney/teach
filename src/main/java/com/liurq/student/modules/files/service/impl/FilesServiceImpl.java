package com.liurq.student.modules.files.service.impl;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.config.util.UUIDGenerator;
import com.liurq.student.modules.files.entity.req.AddFileReq;
import com.liurq.student.modules.files.mapper.FileMapper;
import com.liurq.student.modules.files.mapper.FileRecordMapper;
import com.liurq.student.modules.files.mapper.TRFileRecordMapper;
import com.liurq.student.modules.files.model.File;
import com.liurq.student.modules.files.model.FileRecord;
import com.liurq.student.modules.files.model.TRFileRecord;
import com.liurq.student.modules.files.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FileRecordMapper fileRecordMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private TRFileRecordMapper trFileRecordMapper;

    @Override
    @Transactional
    public RspInfo<String> addFileRecord(AddFileReq req) {
        Date now = new Date();
        String recordId = UUIDGenerator.generate();

        //插入上传文件对象
        for (AddFileReq.FileInfo f:req.getFileList()){
            String fileId = UUIDGenerator.generate();
            File file = new File();
            file.setId(fileId);
            file.setFileName(f.getFileName());
            file.setOldName(f.getOldName());
            file.setSize(f.getFileSize());
            file.setType(f.getFileType());
            fileMapper.insertSelective(file);

            //插入文件关联记录
            TRFileRecord trFileRecord = new TRFileRecord();
            trFileRecord.setId(UUIDGenerator.generate());
            trFileRecord.setFileId(fileId);
            trFileRecord.setRecordId(recordId);
            trFileRecordMapper.insertSelective(trFileRecord);
        }

        //插入文件对象
        FileRecord fileRecord = new FileRecord();
        fileRecord.setId(recordId);
        fileRecord.setStudentName(req.getStudentName());
        fileRecord.setStudentId(req.getStudentId());
        fileRecord.setClazzId(req.getClazzId());
        fileRecord.setClazzName(req.getClazzName());
        fileRecord.setRemark(req.getRemark());
        fileRecord.setEventId(req.getEventId());
        fileRecordMapper.insertSelective(fileRecord);

        return RspInfo.success("success");
    }
}
