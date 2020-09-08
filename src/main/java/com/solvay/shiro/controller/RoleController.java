package com.solvay.shiro.controller;

import com.solvay.shiro.entity.TRole;
import com.solvay.shiro.service.TRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TRole)表控制层
 *
 * @author makejava
 * @since 2020-09-08 12:53:26
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private TRoleService tRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TRole selectOne(Integer id) {
        return this.tRoleService.queryById(id);
    }

}