package com.liurq.config.shiro;

import com.liurq.config.util.JwtUtil;
import com.liurq.config.util.RedisUtil;
import com.liurq.teacher.modules.system.entity.LoginUser;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Author:hyz
 * @Date:2021-07-23
 * @Desc:
 **/
@Configuration
public class ShiroRealm extends AuthorizingRealm {
    @Lazy
    @Resource
    private RedisUtil redisUtil;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 权限信息认证(包括角色以及权限)是用户访问controller的时候才进行验证(redis存储的此处权限信息)
     * 触发检测用户权限时才会调用此方法，例如checkRole,checkPermission
     *
     * @param principals 身份信息
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //模拟获取权限代码，将查询到的权限赋给当前用户
        ArrayList<String> permissions = new ArrayList<>();
        permissions.add("sys:p1");
        info.addStringPermissions(permissions);
        //模拟获取角色代码，将查询到的角色赋给当前用户
        ArrayList<String> roles = new ArrayList<>();
        roles.add("admin");
        info.addRoles(roles);
        return info;
    }

    /**
     * 用户信息认证是在用户进行登录的时候进行验证(不存redis)
     * 也就是说验证用户输入的账号和密码是否正确，错误抛出异常
     *
     * @param auth 用户登录的账号密码信息
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     * @throws Authen   ticationException
     */
//    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        if (token == null) {
            throw new AuthenticationException("token为空!");
        }
        // 校验token有效性
        LoginUser loginUser = new LoginUser();
        loginUser.setUserName(JwtUtil.getUsername(token));
        loginUser.setPassword("admin");
        if (!jwtTokenRefresh(token, loginUser.getUserName())){
            throw new AuthenticationException("Token失效");
        }
        return new SimpleAuthenticationInfo(loginUser, token, getName());
    }


    /**
     * JWTToken刷新生命周期 （实现： 用户在线操作不掉线功能）
     * 1、登录成功后将用户的JWT生成的Token作为k、v存储到cache缓存里面(这时候k、v值一样)，缓存有效期设置为Jwt有效时间的2倍
     * 2、当该用户再次请求时，通过JWTFilter层层校验之后会进入到doGetAuthenticationInfo进行身份验证
     * 3、当该用户这次请求jwt生成的token值已经超时，但该token对应cache中的k还是存在，则表示该用户一直在操作只是JWT的token失效了，程序会给token对应的k映射的v值重新生成JWTToken并覆盖v值，该缓存生命周期重新计算
     * 4、当该用户这次请求jwt在生成的token值已经超时，并在cache中不存在对应的k，则表示该用户账户空闲超时，返回用户信息已失效，请重新登录。
     * 注意： 前端请求Header中设置Authorization保持不变，校验有效性以缓存中的token为准。
     *       用户过期时间 = Jwt有效时间 * 2。
     *
     * @param userName
     * @return
     */
    public boolean jwtTokenRefresh(String token, String userName) {
        String cacheToken = String.valueOf(redisUtil.get(CommonConstant.PREFIX_USER_TOKEN + token));
        if (StringUtils.isNotEmpty(cacheToken)) {
            // 校验token有效性
            if (JwtUtil.verify(cacheToken, userName)) {
                String newAuthorization = JwtUtil.sign(userName);
                // 设置超时时间
                redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, newAuthorization);
                redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME * 2 / 1000);
                return true;
            }
        }
        return false;
    }

    /**
     * 清除当前用户的权限认证缓存
     *
     * @param principals 权限信息
     */
    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

}
