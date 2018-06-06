package cn.kr.authuser.service;

import cn.kr.authuser.domain.User;

import java.util.List;

public interface UserService {


    void register(String username, String password);

    User findOne(String username, String password);

    List<User> findAll();

}
