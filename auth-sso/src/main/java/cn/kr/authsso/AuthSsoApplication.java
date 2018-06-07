package cn.kr.authsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 单点登录服务
 * @author
 *
 * 多模块开发时需要定义包扫描路径
 * @ComponentScan(basePackages = "cn.kr")
 */
@EnableCaching
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@ComponentScan(basePackages = "cn.kr")
public class AuthSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthSsoApplication.class, args);
	}
}
