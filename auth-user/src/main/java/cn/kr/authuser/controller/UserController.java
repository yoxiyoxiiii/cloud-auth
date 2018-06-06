package cn.kr.authuser.controller;

import cn.kr.authuser.domain.User;
import cn.kr.authuser.service.UserService;
import cn.kr.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
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
    public Result register (
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        try {
            userService.register(username, password);
            return Result.success(null);
        } catch (Exception e) {
            log.error(String.format("register fail >>>>>>>>>", e.getLocalizedMessage()));
            return Result.fail();
        }
    }

    /**
     * 根据 username 和 password 查询
     * @param username
     * @param password
     * @return
     */
    @GetMapping("{username}/{password}")
    public Result login(
            @PathVariable("username") String username,
            @PathVariable("username") String password
    ) {
        try {
            User user = userService.findOne(username, password);
            if (StringUtils.isEmpty(user)) {
                return Result.fail();
            }
            return Result.success(true);
        }catch (Exception e) {
            log.error(String.format("findOne fail >>>>>>>>>", e.getLocalizedMessage()));
            return Result.fail();
        }
    }

    /**
     * 获取所有
     * @return
     */
    @GetMapping
    public Result<List<User>> findAll() {
        try{
            List<User> userList = userService.findAll();
            return Result.success(userList);
        }catch (Exception e) {
            log.error(String.format("findAll fail >>>>>>>>>", e.getLocalizedMessage()));
            return Result.fail();
        }

    }
}
