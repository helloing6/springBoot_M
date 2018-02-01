package com.malei.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Before("execution(public * com.malei.controller.UserController.addUserJson(..))")
    public void log(JoinPoint joinPoint){
        logger.info("我拦截了addGirlJson方法");

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",
                joinPoint.getSignature().getDeclaringTypeName()
                        +"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }

    @Pointcut("execution(public * com.malei.controller.UserController.addUserJson(..))")
    public void joinAddUserJson(){
    }

    @AfterReturning(returning = "object",pointcut = "joinAddUserJson()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }

    @After("execution(public * com.malei.controller.UserController.addUserJson(..))")
    public void log3(){
        logger.info("我拦截了addGirlJson方法,但是是方法执行之后");
    }

    /**
     * 拦截UserController类中的所有fan
     */
    @Before("execution(public * com.malei.controller.UserController.*(..))")
    public void log2(){
        logger.info("我拦截了UserController所有方法");
    }

    @Pointcut("execution(public * com.malei.controller.UserController.addUser(..))")
    public void join(){
    }

    @Before("join()")
    public void doBefore(){
        logger.info("我拦截了addGirl");
    }

    @Before("join()")
    public void doAfter(){
        logger.info("我拦截了addGirl,但是是方法执行之后");
    }

}
