package cn.kr.authsso.service;

import cn.kr.authsso.domain.User;

public interface UserService extends BaseService<User> {
    boolean isLogin();
    void login(String username,String password);

}
