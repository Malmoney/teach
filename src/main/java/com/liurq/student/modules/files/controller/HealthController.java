package com.liurq.student.modules.files.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@RestController
public class HealthController {


    @RequestMapping(value = "health",method = {RequestMethod.GET,RequestMethod.POST})
    public String getHealthStatus(){
        return "i am health";
    }
}
