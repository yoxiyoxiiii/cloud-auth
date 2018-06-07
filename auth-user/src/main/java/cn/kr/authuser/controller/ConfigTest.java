package cn.kr.authuser.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTest {

    @Value("${test}")
    private String test;

    @GetMapping
    public String hello() {
        return test;
    }
}
