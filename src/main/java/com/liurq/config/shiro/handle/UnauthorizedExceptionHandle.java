package com.liurq.config.shiro.handle;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.config.shiro.ShiroRealm;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * @Author:hyz
 * @Date:2021-07-27
 * @Desc:
 **/
@ControllerAdvice
public class UnauthorizedExceptionHandle {

    /**
     * 可以获取请求的request对象，按需进行操作
     * 可以获取抛出的异常对象，按需进行操作
     * 可对请求进行重定向，将请求重定向到某个页面或控制器
     * 需要返回json串儿的话，在方法上添加@ResponseBody注解即可
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RspInfo authenticationException(Exception e){
        e.printStackTrace();
        if (e instanceof UnauthorizedException){
            return RspInfo.fail("402","用户未登录！");
        }else if (e instanceof AuthenticationException){
            return RspInfo.fail("402","认证失败！");
        }
        return RspInfo.exception(e, StringUtils.substring(e.getLocalizedMessage(),0,100));
    }

    public static void main(String[] args) {
        ShiroRealm shiroRealm = new ShiroRealm();
    }
}
