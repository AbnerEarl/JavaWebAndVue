package com.ycj.web.controller;

import com.ycj.web.entity.User;
import com.ycj.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/11/15
 * @time: 9:20
 * @fuction: about the role of class.
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping(value = "/id/{id}")
    public String delete(@PathVariable  Long id) {
        userService.deleteById(id);
        return "删除成功";
    }


    @GetMapping(value = "/id/{id}")
    public User findById (@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/username/{username}")
    public User findByUsername (@PathVariable String username) {
        return userService.getByUserName(username);
    }

    @GetMapping(value = "/searchusers/{username}")
    public List<User> findUsersByUsername(@PathVariable String username){
        return userService.getUsersByUserName(username);
    }

    @GetMapping(value = "/")
    public List<User> findAll () {
        return userService.queryAll();
    }
}
