package com.xspace.xspace_admin.common;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code; // 状态码：200代表成功，其他代表失败
    private String message; // 给前端展示的提示信息
    private T data; // 真正要返回的业务数据

    // 成功且带有数据的快捷方法
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    // 成功但不需要返回数据的快捷方法
    public static <T> Result<T> success() {
        return success(null);
    }

    // 失败时的快捷方法
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}