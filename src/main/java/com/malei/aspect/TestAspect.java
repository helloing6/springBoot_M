package com.malei.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    private Logger logger = LoggerFactory.getLogger(TestAspect.class);

    /**
     * 匹配TestService类中的所有方法
     */
    @Pointcut("within(com.malei.service.TestService)")
    public void match(){}

    @Before("match()")
    public void before(){
        logger.info("TestAspect +++++ test");
    }

    /**
     * 匹配TestService类中的所有方法
     */
    @Pointcut("this(com.malei.service.TestService)")
    public void match2(){}

    @Before("match2()")
    public void before2(){
        logger.info("TestAspect2 +++++ test");
    }

    /**
     * 匹配TestService类中，第一个参数是int的方法
     */
    @Pointcut("args(Integer) && within(com.malei.service.TestService)")
    public void match3(){}

    @Before("match3()")
    public void before3(){
        logger.info("before3 +++++ test");
    }

    /**
     * 匹配TestService类中，第一个参数是int,第二个参数是string类型的方法
     */
    @Pointcut("args(Integer,String) && within(com.malei.service.TestService)")
    public void match4(){}

    @Before("match4()")
    public void before4(){
        logger.info("before3 +++++ test");
    }

    @After("match4()")
    public void after4(){
        logger.info("after4 +++++ test");
    }

    /**
     * 注解的拦截
     */
    @Pointcut("@annotation(com.malei.annotation.TestAnnotation)")
    public void match5(){}

    @Before("match5()")
    public void before5(){
        logger.info("@TestAnnotation 方法的注解拦截");
    }

    /**
     * 匹配方法
     */
    @Pointcut("execution(public * com.malei.service.TestService.*(..)))")
    public void match6(){}

    @Before("match6()")
    public void before6(){
        logger.info("before6 方法的注解拦截");
    }


}
