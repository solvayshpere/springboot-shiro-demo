package com.solvay.shiro.service.impl;

import com.solvay.shiro.entity.TPerms;
import com.solvay.shiro.entity.TUser;
import com.solvay.shiro.dao.TUserDao;
import com.solvay.shiro.service.TUserService;
import com.solvay.shiro.util.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2020-09-08 12:53:23
 */
@Service("tUserService")
@Transactional
public class TUserServiceImpl implements TUserService {
    @Resource
    private TUserDao tUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Integer id) {
        return this.tUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAllByLimit(int offset, int limit) {
        return this.tUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser insert(TUser tUser) {
        //获取盐
        String salt = SaltUtils.getSalt(8);
        tUser.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(tUser.getPassword(), salt, 1024);
        tUser.setPassword(md5Hash.toHex());
        this.tUserDao.insert(tUser);
        return tUser;
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserDao.update(tUser);
        return this.queryById(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUserDao.deleteById(id) > 0;
    }

    @Override
    public TUser findByUsername(String username) {
        return this.tUserDao.findByUsername(username);
    }

    @Override
    public TUser findRolesByUsername(String username) {
        return this.tUserDao.findRolesByUsername(username);
    }

    @Override
    public List<TPerms> findPermsByRoleId(Integer id) {
        return this.tUserDao.findPermsByRoleId(id);
    }
}