package cn.kr.authsso.controller;

import cn.kr.authsso.service.UserService;
import cn.kr.exceptions.GeneralException;
import cn.kr.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/sso")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping
    public Result<Integer> register(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        try{
            int id = userService.register(username, password);
            return Result.success("注册成功!",id);
        }catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(400,"注册失败!");
        }

    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public Result login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        try{
            userService.login(username,password);
            return Result.success("登录成功!",null);
        }catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(400,"登录失败!");
        }
    }

    @GetMapping("/isLogin/{token}")
    public Result<Boolean> isLogin(@PathVariable("token") String token) {
        boolean isLogin = userService.isLogin(token);
        return Result.success("查询成功!",isLogin);
    }

    @GetMapping
    public Result<String> hello () {
        return Result.success("hello","hello");
    }
    @GetMapping("isLogin")
    public Result<Boolean> isLogin () {
        return Result.success("hello",false);
    }

}
