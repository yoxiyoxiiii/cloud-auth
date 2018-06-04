package cn.kr.authsso.service;

import cn.kr.authsso.domain.Menu;

import java.util.List;

public interface BaseService<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    T selectByPrimaryKey(Integer id);

    List<T> selectAll();

    int updateByPrimaryKey(T record);
}
