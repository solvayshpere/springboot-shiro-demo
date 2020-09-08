package com.solvay.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TPerms)实体类
 *
 * @author makejava
 * @since 2020-09-08 12:53:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TPerms implements Serializable {
    private static final long serialVersionUID = -13196460659581120L;
    
    private Integer id;
    
    private String name;
    
    private String url;
}