package cn.kr.authzuul.client;

import cn.kr.model.Result;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Fegin 采用 客户端 发现机制，也就是说 是 服务的消费端 定义消费的接口，采用 http 协议，Restful 风格
//在 dubbo 中 是 服务端 暴露接口，采用RPC协议
// name 指定消费的服务
@FeignClient(name = "SSO")
@RequestMapping("/api/user")
public interface UserService {

    @GetMapping("/isLogin/{token}")
    Result<Boolean> isLogin(@PathVariable("token") String token);

    @GetMapping
    Result<String> hello ();

    @GetMapping("isLogin")
    Result<Boolean> isLogin ();

    @GetMapping("toLogin")
    Result toLogin ();
}
