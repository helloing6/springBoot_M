package com.malei.domain.repository;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "userTable")
public class UserTable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;  //用户名
    private String sex;   //性别
    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;  //年龄

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="classId")
    private ClassTable team;

    public ClassTable getTeam() {
        return team;
    }

    public void setTeam(ClassTable team) {
        this.team = team;
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

    @Override
    public String toString() {
        return "UserTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", team=" + team +
                '}';
    }
}
