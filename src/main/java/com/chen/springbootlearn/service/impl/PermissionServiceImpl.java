package com.chen.springbootlearn.service.impl;

import com.chen.springbootlearn.domain.SysPermissionRepository;
import com.chen.springbootlearn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final SysPermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImpl(SysPermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }
}
