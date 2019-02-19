package com.chen.springbootlearn.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from User where username = ?1 limit 1", nativeQuery = true)
    User findByUsername(String username);

    /**
     * 通过用户名和性别查询
     * @param username  用户名
     * @param sex       性别
     * @return
     */
    User findByUsernameAndSex(String username, String sex);
}
