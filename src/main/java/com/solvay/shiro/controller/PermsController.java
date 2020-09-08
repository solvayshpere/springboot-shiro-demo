package com.solvay.shiro.controller;

import com.solvay.shiro.entity.TPerms;
import com.solvay.shiro.service.TPermsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TPerms)表控制层
 *
 * @author makejava
 * @since 2020-09-08 12:53:26
 */
@RestController
@RequestMapping("perms")
public class PermsController {
    /**
     * 服务对象
     */
    @Resource
    private TPermsService tPermsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TPerms selectOne(Integer id) {
        return this.tPermsService.queryById(id);
    }

}