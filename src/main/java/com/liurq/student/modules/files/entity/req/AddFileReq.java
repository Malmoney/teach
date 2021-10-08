package com.liurq.student.modules.files.entity.req;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@Data
public class AddFileReq {

    @NotNull(message = "文件列表不能为空")
    private List<FileInfo> fileList;
    @NotEmpty(message = "学生名称不能为空")
    private String studentName;
    @NotEmpty(message = "学生信息不能为空")
    private String studentId;
    @NotEmpty(message = "班级信息不能为空")
    private String clazzId;
    @NotEmpty(message = "班级名称不能为空")
    private String clazzName;
    private String remark;
    @NotEmpty(message = "事件信息不能为空")
    private String eventId;

    @Data
    public static class FileInfo{
        @NotEmpty(message = "文件名称不可为空")
        private String fileName;
        @NotEmpty(message = "原始名称不能为空")
        private String oldName;
        @Min(value = 1)
        private int fileSize;
        @NotEmpty(message = "文件类型不能为空")
        private String fileType;
    }
}
