package cn.kr.authsso.service.impl;

import cn.kr.authsso.domain.User;
import cn.kr.authsso.service.UserService;
import cn.kr.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@CacheConfig(cacheNames = "sso")
public class UserServiceImpl implements UserService {



    @Autowired
    private RedisService redisService;


    @Override
    public boolean isLogin(String token) {
        return false;
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public int register(String username, String password) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
