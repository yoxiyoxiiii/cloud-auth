package cn.kr.authuser.service;

import cn.kr.authuser.domain.User;

import java.util.List;

/**
 * 用户service
 * @author Administrator
 */
public interface UserService {


    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);

    /**
     * 根据 用户名和密码 查询 用户
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User findOne(String username, String password);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

}
