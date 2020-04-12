package com.lsw.security.pac;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@Service
public class MyUserDetailsService implements UserDetailsService {
    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。
        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        // TODO 数据库操作查找用户名密码
        if(username.equals("daadreeam")) {
            //假设返回的用户信息如下;
            MyUser userInfo=new MyUser();
            userInfo.setUsername("admin");
            userInfo.setPassword("lsw");
            MyRole role = new MyRole(1,"admin");
            List<MyRole> list = new ArrayList();
            list.add(role);
            userInfo.setRoles(list);
            return userInfo;
        } else {
            MyUser userInfo=new MyUser();
            userInfo.setUsername("others");
            userInfo.setPassword("lsw");
            MyRole role = new MyRole(1,"test");
            List<MyRole> list = new ArrayList();
            list.add(role);
            userInfo.setRoles(list);
            return userInfo;
        }
    }
}
