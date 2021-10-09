package com.liurq.teacher.modules.system.controller;

import com.liurq.config.entity.rsp.RspInfo;
import com.liurq.config.shiro.CommonConstant;
import com.liurq.config.util.JwtUtil;
import com.liurq.config.util.RedisUtil;
import com.liurq.teacher.modules.system.entity.LoginRsp;
import com.liurq.teacher.modules.system.entity.LoginUser;
import com.liurq.teacher.modules.system.entity.TeacherInfoRsp;
import com.liurq.teacher.modules.system.model.SysUser;
import com.liurq.teacher.modules.system.service.SysUserService;
import com.liurq.teacher.modules.system.service.TeacherService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author:hyz
 * @Date:2021-10-08
 * @Desc:
 **/
@RequestMapping("/teacher/system")
@RestController
public class LoginController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RspInfo login(@RequestBody @Valid LoginUser loginUser){

        //1、根据参数查询数据库中的用户
        SysUser user = sysUserService.getUserByUserName(loginUser.getUserName());
        if (user == null){
            throw new AuthenticationException();
        }
        //2、对用户的密码进行校验-如果需要进行免密登录，则不校验直接进行下一步即可
        String password = loginUser.getPassword();
        String hashPwd = new Sha256Hash(password, loginUser.getUserName(), 1).toBase64();
        if (!hashPwd.equals(user.getPassword())){
            throw new AuthenticationException();
        }

        //3、对用户的状态进行校验，校验用户是否被冻结等
        //4、生成token并返回
        String token = JwtUtil.sign(loginUser.getUserName());
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
        redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME*2 / 1000);

        //查询用户信息
        LoginRsp loginRsp = new LoginRsp();
        TeacherInfoRsp teacherInfo = teacherService.getTeacherInfoById(user.getInfoId());
        loginRsp.setTeacherInfo(teacherInfo);
        loginRsp.setToken(token);

        return RspInfo.success(loginRsp);
    }


    public static void main(String[] args) {
        String hashPwd = new Sha256Hash("admin", "admin", 1).toBase64();
        System.out.println(hashPwd);
    }
}
