package com.solvay.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * (TRole)实体类
 *
 * @author makejava
 * @since 2020-09-08 12:53:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TRole implements Serializable {
    private static final long serialVersionUID = -42054010137301967L;
    
    private Integer id;
    
    private String name;

    private List<TPerms> perms;

}