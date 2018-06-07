package cn.kr.authuser.service.impl;

import cn.kr.authuser.dao.UserMapper;
import cn.kr.authuser.domain.User;
import cn.kr.authuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(String username, String password) {
        User user = User
                .builder()
                .password(password)
                .username(username)
                .build();
        userMapper.insert(user);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public User findOne(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username,password);
        return user;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
