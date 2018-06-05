package cn.kr.authzuul.controller;

import cn.kr.authzuul.client.UserService;
import cn.kr.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result hello() {
        Result<String> result = userService.hello();
        return Result.success("测试！",result.getData());
    }
}
