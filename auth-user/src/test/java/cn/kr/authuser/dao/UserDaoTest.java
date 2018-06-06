package cn.kr.authuser.dao;

import cn.kr.authuser.AuthUserApplicationTests;
import cn.kr.authuser.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends AuthUserApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("zhangs", "zhangs");
        Assert.assertNotEquals(null,user);
    }
}
