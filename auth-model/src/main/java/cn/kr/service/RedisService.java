package cn.kr.service;

public interface RedisService {

    void set(String k,Object v);
    void set(String k,Object v,long timeSec);
    Object get(String k);

}
