package cn.kr.authconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 统一配置管理
 * @author Administrator
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class AuthConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthConfigApplication.class, args);
	}
}
