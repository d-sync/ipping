package com.ipping.demo.service.impl;

import com.ipping.demo.model.User;
import com.ipping.demo.repository.interfaces.UserRepository;
import com.ipping.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CommonServiceImpl<User> implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}
