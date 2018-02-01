package com.malei.service;

import com.malei.annotation.TestAnnotation;
import com.malei.aspect.HttpAspect;
import com.malei.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private Logger logger = LoggerFactory.getLogger(TestService.class);

    public void test(Integer id) throws AppException {
        logger.info("TestService +++++ test");
    }

    public void test(Integer id,String om) throws AppException {
        logger.info("TestService +Integer id,String om");
    }

    @TestAnnotation
    public void test3() throws AppException {
        logger.info("test3@TestAnnotation 方法的注解拦截");
    }

    public void test4() throws AppException {
        logger.info("test4");
    }
}
