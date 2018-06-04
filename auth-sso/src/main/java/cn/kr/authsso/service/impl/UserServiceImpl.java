package cn.kr.authsso.service.impl;

import cn.kr.authsso.dao.UserMapper;
import cn.kr.authsso.domain.Menu;
import cn.kr.authsso.domain.User;
import cn.kr.authsso.service.UserService;
import cn.kr.exceptions.NotFindUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }


    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public void login(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username,password);
        if(StringUtils.isEmpty(user)) {//用户名或密码错误！
            throw new NotFindUserException();
        }
    }
}
