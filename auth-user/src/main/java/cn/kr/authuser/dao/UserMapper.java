package cn.kr.authuser.dao;

import cn.kr.authuser.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户UserMapper
 * @author Administrator
 */
@Mapper
public interface UserMapper {

    /**
     *根据 id 删除
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 新增
     * @param record
     * @return
     */
    int insert(User record);


    /**
     * 根据id 查询
     * @param id 主键
     * @return
     */
    User selectByPrimaryKey(Integer id);


    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();

    /**
     *更新实体
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据 username 和 password 查询
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password") String password);

}