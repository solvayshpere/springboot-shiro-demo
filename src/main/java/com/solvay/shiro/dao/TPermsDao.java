package com.solvay.shiro.dao;

import com.solvay.shiro.entity.TPerms;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TPerms)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-08 12:53:26
 */
public interface TPermsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPerms queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TPerms> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tPerms 实例对象
     * @return 对象列表
     */
    List<TPerms> queryAll(TPerms tPerms);

    /**
     * 新增数据
     *
     * @param tPerms 实例对象
     * @return 影响行数
     */
    int insert(TPerms tPerms);

    /**
     * 修改数据
     *
     * @param tPerms 实例对象
     * @return 影响行数
     */
    int update(TPerms tPerms);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}