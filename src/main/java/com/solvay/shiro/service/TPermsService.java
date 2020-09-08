package com.solvay.shiro.service;

import com.solvay.shiro.entity.TPerms;
import java.util.List;

/**
 * (TPerms)表服务接口
 *
 * @author makejava
 * @since 2020-09-08 12:53:26
 */
public interface TPermsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPerms queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TPerms> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tPerms 实例对象
     * @return 实例对象
     */
    TPerms insert(TPerms tPerms);

    /**
     * 修改数据
     *
     * @param tPerms 实例对象
     * @return 实例对象
     */
    TPerms update(TPerms tPerms);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}