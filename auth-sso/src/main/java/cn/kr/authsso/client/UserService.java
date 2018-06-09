package cn.kr.authsso.client;

import cn.kr.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * user 服务客户端接口
 * @author yj
 */
@FeignClient(value = "user")
@RequestMapping("/api/user")
public interface UserService {

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping
    Result<Integer> register (
            @RequestParam("username") String username,
            @RequestParam("password") String password
    );


    /**
     * 用户登录
     * @param username
     * @param password
     */
    @GetMapping("{username}/{password}")
     Result login(
            @PathVariable("username") String username,
            @PathVariable("username") String password
    );

//    /**
//     * 用户是否登录
//     * @param token
//     * @return
//     */
//    boolean isLogin(String token);

}
