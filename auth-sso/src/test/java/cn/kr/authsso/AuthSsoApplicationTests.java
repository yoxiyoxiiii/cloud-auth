package cn.kr.authsso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.DefaultRedisCachePrefix;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthSsoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisCacheManager cacheManager;
	@Test
	public void contextLoads() {
		Collection<String> cacheNames = cacheManager.getCacheNames();
	}

}
