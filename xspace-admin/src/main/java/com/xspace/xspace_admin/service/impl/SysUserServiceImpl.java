package com.xspace.xspace_admin.service.impl;

import com.xspace.xspace_admin.entity.SysUser;
import com.xspace.xspace_admin.mapper.SysUserMapper;
import com.xspace.xspace_admin.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    // 注入底层查数据库的 Mapper
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByUsername(String username) {
        // 这里只是简单查询，以后真实的业务中，这里会写很多逻辑，比如校验等
        return sysUserMapper.selectByUsername(username);
    }
}