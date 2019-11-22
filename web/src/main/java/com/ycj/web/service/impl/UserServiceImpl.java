package com.ycj.web.service.impl;

import com.ycj.web.entity.User;
import com.ycj.web.repository.UserRepository;
import com.ycj.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/11/15
 * @time: 9:19
 * @fuction: about the role of class.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> getUsersByUserName(String username) {
        return userRepository.findUsersByUsernameIsContaining(username);
    }

    @Override
    public List<User> queryAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
