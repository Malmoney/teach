package com.liurq.student.modules.files.service;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.model.Event;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
public interface EventService {

    RspInfo<List<Event>> selectEventList();
}
