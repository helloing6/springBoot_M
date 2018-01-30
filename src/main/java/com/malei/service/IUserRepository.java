package com.malei.service;

import com.malei.domain.repository.GrilInfo;
import com.malei.domain.repository.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserTable,Integer> {
}
