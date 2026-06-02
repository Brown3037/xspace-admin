package com.xspace.xspace_admin.controller;

import com.xspace.xspace_admin.common.Result;
import com.xspace.xspace_admin.entity.SysUser;
import com.xspace.xspace_admin.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // 注入业务层 Service
    @Resource
    private SysUserService sysUserService;

    // 保留之前的 hello 接口
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("Hello X-Space! 项目初始化并联调成功！");
    }

    // ⭐ 新增：查询数据库的测试接口
    @GetMapping("/user/{username}")
    public Result<SysUser> getUser(@PathVariable String username) {
        SysUser user = sysUserService.getUserByUsername(username);

        if (user == null) {
            return Result.error(404, "该用户不存在或已被删除");
        }

        // 企业级规范：绝不能把密码原封不动地返回给前端！
        user.setPassword("******");

        return Result.success(user);
    }
}