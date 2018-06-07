package cn.kr.authsso.dao;

import cn.kr.authsso.domain.Menu;
import java.util.List;

/**
 * menu mapper
 * @author Administrator
 */
public interface MenuMapper {

    /**
     * 根据id 删除
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 新增 菜单
     * @param record 菜单实体
     * @return
     */
    int insert(Menu record);


    /**
     * 根据 id 查询
     * @param id 主键
     * @return
     */
    Menu selectByPrimaryKey(Integer id);


    /**
     * 获取全部 菜单
     * @return
     */
    List<Menu> selectAll();


    /**
     * 更新 菜单
     * @param record 菜单实体
     * @return
     */
    int updateByPrimaryKey(Menu record);
}