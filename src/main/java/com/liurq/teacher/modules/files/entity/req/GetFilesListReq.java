package com.liurq.teacher.modules.files.entity.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@Data
public class GetFilesListReq {

    @NotEmpty
    private String eventId;
    @NotEmpty
    private String classId;

}
