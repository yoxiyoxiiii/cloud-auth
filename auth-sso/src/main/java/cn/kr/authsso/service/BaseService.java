package cn.kr.authsso.service;


import java.util.List;

/**
 * BaseService 抽取
 * @author Administrator
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 根据id 删除
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增实体
     * @param record 实体
     * @return
     */
    int insert(T record);


    /**
     * 根据id 查询
     * @param id 主键
     * @return 实体
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 获取所有
     * @return
     */
    List<T> selectAll();

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);
}
