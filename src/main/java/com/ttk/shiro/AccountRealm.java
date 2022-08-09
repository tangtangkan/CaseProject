package com.ttk.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.ttk.entity.User;
import com.ttk.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {

    private final JwtUtils jwtUtils;

    private final UserService userService;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public AccountRealm(JwtUtils jwtUtils, UserService userService) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    /**
     * 为了让realm支持jwt的凭证校验
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 权限校验
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录认证校验
     * 通过jwt获取到用户信息，判断用户的状态，最后异常就抛出对应的异常信息，否者封装成SimpleAuthenticationInfo返回给shiro
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("JwtFilter++++++++++doGetAuthenticationInfo");

        JwtToken jwt = (JwtToken) token;
        log.info("jwt----------------->{}", jwt.getCredentials());

        String principal = (String) jwt.getPrincipal();
        Claims claimByToken = jwtUtils.getClaimByToken(principal);

        System.out.println("签发时间" + sdf.format(claimByToken.getIssuedAt()));
        System.out.println("过期时间" + sdf.format(claimByToken.getExpiration()));

        String userId = claimByToken.getSubject();
        User user = userService.getById(Long.parseLong(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在！");
        }
        AccountProfile profile = new AccountProfile(user.getUid(), user.getLoginName());
        log.info("profile----------------->{}", profile);
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
    }
}

