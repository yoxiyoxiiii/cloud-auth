package cn.kr.service;

/**
 * 操作redis 类
 * @author Administrator
 */
public interface RedisService {

    /**
     * 写入redis
     * @param k key
     * @param v value
     */
    void set(String k,Object v);

    /**
     * 写入redis 设置过期时间
     * @param k key
     * @param v value
     * @param timeSec 存活时长，秒
     */
    void set(String k, Object v,long timeSec);

    /**
     * 根据 key 从redis 查询
     * @param k key
     * @return Object
     */
    Object get(String k);

}
