package com.malei;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<GrilInfo,Integer>{

    /**
     * 通过年龄查询
     */
    List<GrilInfo> findByAge(Integer age);
}
