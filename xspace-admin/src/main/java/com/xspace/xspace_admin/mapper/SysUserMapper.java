package com.xspace.xspace_admin.mapper;

import com.xspace.xspace_admin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    /**
     * 根据用户名查询未被删除的用户
     */
    SysUser selectByUsername(String username);
}