package com.malei.repository;

import com.malei.domain.repository.GrilInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGirlRepository extends JpaRepository<GrilInfo,Integer>{

    /**
     * 通过年龄查询
     */
    List<GrilInfo> findByAge(Integer age);
}
