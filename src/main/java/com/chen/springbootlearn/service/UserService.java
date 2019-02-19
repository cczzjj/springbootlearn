package com.chen.springbootlearn.service;

import com.chen.springbootlearn.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUsername(String username);

    User findById(Integer id);

    User save(User user);

    boolean delete(Integer id);
}
