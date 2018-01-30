package com.malei.controller;

import com.malei.domain.repository.GrilInfo;
import com.malei.domain.repository.UserTable;
import com.malei.service.IGirlRepository;
import com.malei.service.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    /**
     * 添加用户
     * private String name;  //用户名
     private String sex;   //性别
     private Integer age;  //年龄
     private String classId;  //班级id 外键
     private String classMessage;  //班级名称
     */
    @PostMapping(value = "/addUser")
    public UserTable addGirl(@RequestParam("name") String name,
                             @RequestParam("sex") String sex,
                             @RequestParam("age") Integer age,
                             @RequestParam("classId") Integer classId){
        UserTable info = new UserTable();
        info.setName(name);
        info.setSex(sex);
        info.setAge(age);
        info.setClassId(classId);
        return userRepository.save(info);
    }

}
