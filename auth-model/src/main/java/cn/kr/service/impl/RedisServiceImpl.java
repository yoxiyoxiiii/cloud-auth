package cn.kr.service.impl;

import cn.kr.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Object get(String k) {
        Object value = redisTemplate.opsForValue().get(k);
        return value;
    }

    @Override
    public void set(String k, Object v) {
        redisTemplate.opsForValue().set(k,v);
    }

    @Override
    public void set(String k,Object v,long timeSec) {
        redisTemplate.opsForValue().set(k,v,timeSec);
    }
}
