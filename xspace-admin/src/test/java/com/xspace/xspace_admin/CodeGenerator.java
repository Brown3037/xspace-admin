package com.xspace.xspace_admin;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        // 1. 数据库连接配置 (注意修改密码)
        String url = "jdbc:mysql://localhost:3306/xspace?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String username = "root";
        String password = "pzg63061128"; // <--- 这里改成你的 MySQL 密码！

        // 2. 获取当前项目的根目录
        String projectPath = System.getProperty("user.dir") + "/xspace-admin";

        // 3. 执行代码生成
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("Brown") // 设置作者名字
                            .outputDir(projectPath + "/src/main/java") // 指定 Java 代码输出目录
                            .disableOpenDir(); // 生成完毕后不自动打开文件夹
                })
                .packageConfig(builder -> {
                    builder.parent("com.xspace.xspace_admin") // 设置父包名
                            // 单独指定 XML 文件的输出目录到 resources/mapper 下
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    // ⭐ 指定我们要生成的 4 张表 (sys_user 之前手写过了，就不生成了)
                    builder.addInclude("sys_role", "sys_menu", "sys_user_role", "sys_role_menu")
                            .entityBuilder().enableLombok() // 实体类自动加 @Data 注解
                            .controllerBuilder().enableRestStyle() // Controller 自动加 @RestController 注解
                            .mapperBuilder().enableMapperAnnotation(); // Mapper 自动加 @Mapper 注解
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .execute();
    }
}