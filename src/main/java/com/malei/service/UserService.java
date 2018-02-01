package com.malei.service;

import com.malei.domain.repository.UserTable;
import com.malei.enums.ResultEnum;
import com.malei.exception.AppException;
import com.malei.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserTable getUserAge(Integer id) throws AppException {
        UserTable info = userRepository.findOne(id);
        Integer age = info.getAge();
        if(age < 20){
            throw new AppException(ResultEnum.PRIMARY_SHOOL);
        }else if(age > 35){
            throw new AppException(ResultEnum.MIDDLE_SCHOOL);
        }
        return info;
    }
}
