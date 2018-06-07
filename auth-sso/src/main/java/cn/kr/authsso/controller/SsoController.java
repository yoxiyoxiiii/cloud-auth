package cn.kr.authsso.controller;

import cn.kr.authsso.client.UserService;
import cn.kr.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 单点登录
 * @author Administrator
 */
@Api("单点登录")
@Slf4j
@RestController
@RequestMapping("/api/sso")
public class SsoController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping
    public Result<Integer> register(
            @RequestParam(name = "username") @ApiParam("用户名") String username,
            @RequestParam(name = "password") @ApiParam("密码") String password
    ) {
        try{
            int id = userService.register(username, password);
            return Result.success(id);
        }catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail();
        }

    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("login")
    public Result login(
            @RequestParam(name = "username") @ApiParam("用户名") String username,
            @RequestParam(name = "password") @ApiParam("密码")String password
    ) {
        try{
            userService.login(username,password);
            return Result.success(null);
        }catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail();
        }
    }

    @GetMapping("/isLogin/{token}")
    public Result<Boolean> isLogin(@PathVariable("token") String token) {
        boolean isLogin = userService.isLogin(token);
        return Result.success(isLogin);
    }

    @GetMapping
    public Result<String> hello () {
        return Result.success(null);
    }
    @GetMapping("isLogin")
    public Result<Boolean> isLogin () {
        return Result.success(false);
    }

}
