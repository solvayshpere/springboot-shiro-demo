package com.solvay.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-09-08 12:53:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TUser implements Serializable {
    private static final long serialVersionUID = -51938961478364855L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String salt;

    private List<TRole> roles;

}