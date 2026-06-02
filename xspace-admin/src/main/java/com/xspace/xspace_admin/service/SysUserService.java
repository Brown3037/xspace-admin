package com.xspace.xspace_admin.service;

import com.xspace.xspace_admin.entity.SysUser;

public interface SysUserService {
    /**
     * 根据用户名获取用户信息
     */
    SysUser getUserByUsername(String username);
}