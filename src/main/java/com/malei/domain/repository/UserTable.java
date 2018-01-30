package com.malei.domain.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userTable")
public class UserTable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;  //用户名
    private String sex;   //性别
    private Integer age;  //年龄
    private Integer classId;  //班级id 外键
    private String classMessage;  //班级名称

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassMessage() {
        return classMessage;
    }

    public void setClassMessage(String classMessage) {
        this.classMessage = classMessage;
    }
}
