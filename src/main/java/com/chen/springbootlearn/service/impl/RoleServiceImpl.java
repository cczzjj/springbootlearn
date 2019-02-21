package com.chen.springbootlearn.service.impl;

import com.chen.springbootlearn.domain.SysRoleRepository;
import com.chen.springbootlearn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleRepository roleRepository;
}
