package com.ssm.runoob.shiro;

import com.ssm.runoob.model.User;
import com.ssm.runoob.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phil on 2016/2/26.
 *
 * @author Phil
 */
public class RunoobRealm extends AuthorizingRealm {
    private static final Logger logger = Logger.getLogger(RunoobRealm.class);
    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取权限
        List<String> permsNames = new ArrayList<>();
        info.addStringPermissions(permsNames);//授权
        return info;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String mobile = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        logger.info("我来认证:-->" + mobile + "--" + password);
        User user = userService.findByMobilePassword(mobile,password);
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
