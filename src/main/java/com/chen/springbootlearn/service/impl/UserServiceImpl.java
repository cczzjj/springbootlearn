package com.chen.springbootlearn.service.impl;

import com.chen.springbootlearn.domain.User;
import com.chen.springbootlearn.domain.UserRepository;
import com.chen.springbootlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        Integer id = user.getId();
        Optional<User> userOptional;
        if (id != null && (userOptional = userRepository.findById(id)).isPresent()) {
            User record = userOptional.get();
            if (!"".equals(user.getUsername())) {
                record.setUsername(user.getUsername());
            }
            if (user.getBirthday() != null) {
                record.setBirthday(user.getBirthday());
            }
            if (!"".equals(user.getSex())) {
                record.setSex(user.getSex());
            }
            if (!"".equals(user.getAddress())) {
                record.setAddress(user.getAddress());
            }
            user = userRepository.save(record);
        }
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Integer id) {
        userRepository.deleteById(id);
        return true;
    }
}
