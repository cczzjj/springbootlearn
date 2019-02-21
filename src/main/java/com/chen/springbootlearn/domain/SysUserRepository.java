package com.chen.springbootlearn.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

    @Query(value = "select * from user where username = ?1 limit 1", nativeQuery = true)
    SysUser findByUsername(String username);
}
