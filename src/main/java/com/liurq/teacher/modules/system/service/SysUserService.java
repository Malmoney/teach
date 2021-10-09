package com.liurq.teacher.modules.system.service;

import com.liurq.teacher.modules.system.model.SysUser;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
public interface SysUserService {

    /**
     * 根据用户名获取用户
     * @param userName
     */
    SysUser getUserByUserName(String userName);

}
