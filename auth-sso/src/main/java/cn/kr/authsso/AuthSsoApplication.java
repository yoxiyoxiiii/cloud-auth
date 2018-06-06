package cn.kr.authsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
//多模块开发时需要定义包扫描路径
@ComponentScan(basePackages = "cn.kr")
public class AuthSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthSsoApplication.class, args);
	}
}
