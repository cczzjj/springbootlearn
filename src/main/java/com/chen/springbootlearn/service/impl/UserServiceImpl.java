package com.chen.springbootlearn.service.impl;

import com.chen.springbootlearn.domain.SysUser;
import com.chen.springbootlearn.domain.SysUserRepository;
import com.chen.springbootlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public SysUser getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
