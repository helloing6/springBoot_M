package com.malei.handle;

import com.malei.controller.UserController;
import com.malei.domain.entity.Result;
import com.malei.exception.AppException;
import com.malei.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof AppException){
            AppException appException = (AppException)e;
            return ResultUtils.error(appException.getCode(),appException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtils.error(-1,"未知错误");
        }
    }
}
