package com.ssm.runoob.shiro;

import com.ssm.runoob.model.User;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phil on 2016/2/26.
 *
 * @author Phil
 */
public class MyRealm extends AuthorizingRealm {
    private static final Logger logger = Logger.getLogger(MyRealm.class);

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
        System.out.println("xxxxx");
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
        String pwd = new String(usernamePasswordToken.getPassword());
        logger.info("我来认证:-->" + usernamePasswordToken.getUsername() + "--" + pwd);
//        ExhibitionUser user = exhibitionUserService.getExhibitionUserByPhoneAndPwd(usernamePasswordToken.getUsername(), pwd);
//        if (null == user) return null;
        User user = new User();
//        userHolderService.setConsoleUser(user);//存入session
//        List<String> permsNames = JRedisUtil.getInstance().lrangeAll(Constants.KEY_REDIS_SHIRO_USER_PERMS + user.getId());
//        loggerGER.error("REDIS PERMS!" + JSON.toJSONString(permsNames));
        return new SimpleAuthenticationInfo(user, pwd, getName());
    }
}
