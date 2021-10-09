package com.liurq.teacher.modules.system.service.impl;

import com.liurq.teacher.modules.system.mapper.SysUserMapper;
import com.liurq.teacher.modules.system.model.SysUser;
import com.liurq.teacher.modules.system.model.SysUserExample;
import com.liurq.teacher.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-10-09
 * @Desc:
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 根据用户名获取用户
     *
     * @param userName
     */
    @Override
    public SysUser getUserByUserName(String userName) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria()
                .andUsernameEqualTo(userName)
                .andDeletedEqualTo("0");
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers != null && sysUsers.size() > 0){
            return sysUsers.get(0);
        }
        return null;
    }
}
