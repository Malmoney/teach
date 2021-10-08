package com.liurq.student.modules.files.service.impl;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.mapper.EventMapper;
import com.liurq.student.modules.files.model.Event;
import com.liurq.student.modules.files.model.EventExample;
import com.liurq.student.modules.files.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventMapper eventMapper;


    @Override
    public RspInfo<List<Event>> selectEventList() {
        Date now = new Date();
        EventExample eventExample = new EventExample();
        eventExample.createCriteria()
                .andDeletedEqualTo("0")
                .andStartDateLessThan(now)
                .andEndDateGreaterThan(now);
        List<Event> events = eventMapper.selectByExample(eventExample);
        return RspInfo.success(events);
    }
}
