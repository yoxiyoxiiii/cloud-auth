package cn.kr.authsso.client;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * user 服务客户端接口
 * @author yj
 */
@FeignClient(value = "user")
public interface UserService {

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    int register(String username, String password);


    /**
     * 用户登录
     * @param username
     * @param password
     */
    void login(String username, String password);

    /**
     * 用户是否登录
     * @param token
     * @return
     */
    boolean isLogin(String token);

}
