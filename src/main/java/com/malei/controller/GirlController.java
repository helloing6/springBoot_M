package com.malei.controller;

import com.malei.service.IGirlRepository;
import com.malei.domain.repository.GrilInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private IGirlRepository girlRepository;

    /**
     * 获取女孩列表
     * @return
     */
    @GetMapping(value = "/getGirls")
    public List<GrilInfo> getGirls(){
        return girlRepository.findAll();
    }

    /**
     * 添加一条女孩
     * @return
     */
    @PostMapping(value = "/addGirl")
    public GrilInfo addGirl(@RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){
        GrilInfo info = new GrilInfo();
        info.setCupSize(cupSize);
        info.setAge(age);
        return girlRepository.save(info);
    }

    /**
     * 查询一个女生
     */
    @GetMapping(value = "/findGirl/{id}")
    public GrilInfo addGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     */
    @PostMapping(value = "/updateGirl/{id}")
    public GrilInfo updateGirl(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age){
        GrilInfo info = new GrilInfo();
        info.setId(id);
        info.setCupSize(cupSize);
        info.setAge(age);
        return girlRepository.save(info);
    }

    /**
     * 删除一个女生
     */
    @GetMapping(value = "/deleteGirl/{id}")
    public String deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
        return "成功";
    }

    /**
     * 通过年龄查询女生列表
     */
    @GetMapping(value = "/getGirlsByAge/{age}")
    public List<GrilInfo> getGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }



}
