package com.solvay.shiro.service.impl;

import com.solvay.shiro.entity.TPerms;
import com.solvay.shiro.dao.TPermsDao;
import com.solvay.shiro.service.TPermsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPerms)表服务实现类
 *
 * @author makejava
 * @since 2020-09-08 12:53:26
 */
@Service("tPermsService")
public class TPermsServiceImpl implements TPermsService {
    @Resource
    private TPermsDao tPermsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TPerms queryById(Integer id) {
        return this.tPermsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TPerms> queryAllByLimit(int offset, int limit) {
        return this.tPermsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tPerms 实例对象
     * @return 实例对象
     */
    @Override
    public TPerms insert(TPerms tPerms) {
        this.tPermsDao.insert(tPerms);
        return tPerms;
    }

    /**
     * 修改数据
     *
     * @param tPerms 实例对象
     * @return 实例对象
     */
    @Override
    public TPerms update(TPerms tPerms) {
        this.tPermsDao.update(tPerms);
        return this.queryById(tPerms.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tPermsDao.deleteById(id) > 0;
    }
}