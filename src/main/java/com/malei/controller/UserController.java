package com.malei.controller;

import com.malei.domain.entity.Result;
import com.malei.domain.repository.UserTable;
import com.malei.exception.AppException;
import com.malei.repository.IUserRepository;
import com.malei.service.UserService;
import com.malei.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserService mUserService;

    /**
     * 添加用户
     */
    @PostMapping(value = "/addUser")
    public UserTable addUser(@RequestParam("name") String name,
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

    /**
     * 当年龄小于18岁的时候，不可以保存，返回null
     * @param userTable
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/addUserJson")
    public Result<UserTable> addUserJson(@Valid UserTable userTable, BindingResult bindingResult){
        Result<UserTable> result = new Result<>();
        if(bindingResult.hasErrors()){
            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(userRepository.save(userTable));
    }

    /**
     * 更新数据
     * @param userId
     * @param name
     * @param sex
     * @param age
     * @param classId
     * @return
     */
    @PostMapping(value = "/updateUser")
    public UserTable updateUser(@RequestParam("userId") Integer userId,
                                @RequestParam("name") String name,
                                @RequestParam("sex") String sex,
                                @RequestParam("age") Integer age,
                                @RequestParam("classId") Integer classId){
        UserTable info = new UserTable();
        info.setId(userId);
        info.setName(name);
        info.setSex(sex);
        info.setAge(age);
        info.setClassId(classId);
        return userRepository.save(info);
    }

    /**
     * 删除数据
     * @param userId
     */
    @PostMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam("userId") Integer userId){
        userRepository.delete(userId);
    }

    /**
     * 获取所有
     * @return
     */
    @PostMapping(value = "/getAllUser")
    public List<UserTable> getAllUser(){
        return userRepository.findAll();
    }

    /**
     * 获取年龄
     * @return
     */
    @GetMapping(value = "/getUserAge/{id}")
    public UserTable getUserAge(@PathVariable("id") Integer id) throws AppException {
        return mUserService.getUserAge(id);
    }
}
