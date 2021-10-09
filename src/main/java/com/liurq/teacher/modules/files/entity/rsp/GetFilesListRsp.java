package com.liurq.teacher.modules.files.entity.rsp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liurq.student.modules.files.model.File;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@Data
public class GetFilesListRsp implements Serializable {

    private List<File> filesList;
    private String studentId;
    private String studentName;
    private String remark;
    @JsonFormat(pattern = "yy年M月d日 HH:mm",timezone="GMT+8")
    private Date uploadTime;
    private String recordId;
    private String urlPrefix;
}
