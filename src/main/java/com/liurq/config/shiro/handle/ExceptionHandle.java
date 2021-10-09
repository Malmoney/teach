package com.liurq.config.shiro.handle;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@RestController
public class ExceptionHandle {

    @RequestMapping("exceptionHandle")
    public void errorHandle(HttpServletRequest request) throws Exception {
        Exception e = (Exception)request.getAttribute("exceptionInfo");
        throw e;
    }

}
