package com.malei.utils;

import com.malei.domain.entity.Result;

public class ResultUtils {

    public static Result success(Object object){
        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code ,String error){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(error);
        return result;
    }
}
