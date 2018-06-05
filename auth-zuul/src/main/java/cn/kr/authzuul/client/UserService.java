package cn.kr.authzuul.client;

import cn.kr.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name 指定微服务名 注册中的服务名
 * Feign 是客户端采用客户端发现服务的方式 客户端定义需要调用的接口，是伪RPC。通过hppt 的 restful 风格远程调用
 * dubbo 采用 rpc 协议由服务端暴露service接口，在性能方面稍由于http 方式，但没有springcloud 解决方案全面
 */
@FeignClient(name = "sso")
@RequestMapping("/api/sso")
public interface UserService {

     @GetMapping("isLogin")
     Result<Boolean> isLogin();

}
