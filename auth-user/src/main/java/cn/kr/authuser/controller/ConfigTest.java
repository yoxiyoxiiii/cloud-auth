package cn.kr.authuser.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//刷新 test 属性，动态刷新。
public class ConfigTest {
    @Value("${test}")
    private String test;

    @GetMapping
    public String hello() {
        return test;
    }
}
