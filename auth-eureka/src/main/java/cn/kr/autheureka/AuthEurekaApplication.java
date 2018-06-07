package cn.kr.autheureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaServer
public class AuthEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthEurekaApplication.class, args);
	}
}
