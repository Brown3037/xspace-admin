package com.xspace.xspace_admin.controller;

import com.xspace.xspace_admin.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public Result<String> hello() {
        // 使用我们刚刚写好的统一响应格式返回数据
        return Result.success("Hello X-Space! 项目初始化并联调成功！");
    }
}