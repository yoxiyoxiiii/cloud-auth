package cn.kr.authsso.client;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * user 服务客户端接口
 * @author yj
 */
@FeignClient(value = "user")
public interface UserService {
    int register(String username, String password);

    void login(String username, String password);

    boolean isLogin(String token);

}
