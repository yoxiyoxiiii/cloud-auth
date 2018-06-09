package cn.kr.authsso;

import cn.kr.authsso.client.UserService;
import cn.kr.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthSsoApplicationTests {

	@Autowired
	private RedisService redisService;

	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
		redisService.set("sso:sso:key","sso");
	}

}
