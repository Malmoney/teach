package com.liurq.student.modules.files.controller;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.student.modules.files.model.Event;
import com.liurq.student.modules.files.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@RequestMapping(value = "/event")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/selectEventList",method = {RequestMethod.POST,RequestMethod.GET})
    public RspInfo<List<Event>> selectEventList(){
        return eventService.selectEventList();
    }
}

