package com.xspace.xspace_admin.controller;

import com.xspace.xspace_admin.common.Result;
import com.xspace.xspace_admin.entity.SysRole;
import com.xspace.xspace_admin.service.ISysRoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;

    @GetMapping("/list")
    public Result<List<SysRole>> list() {
        List<SysRole> roles = sysRoleService.list();
        return Result.success(roles);
    }
}