package com.malei.exception;

import com.malei.enums.ResultEnum;

public class AppException extends RuntimeException{

    private Integer code;

    public AppException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
