package com.ycj.web.service;

import com.ycj.web.entity.User;

import java.util.List;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2019/11/15
 * @time: 9:18
 * @fuction: about the role of class.
 */
public interface UserService {

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    User updateUser(User user);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getById(Long id);

    /**
     * 根据名称获取用户
     * @param username
     * @return
     */
    User getByUserName(String username);

    /**
     * @author: Frank
     * @email 1320259466@qq.com
     * @date: 2019/11/15 10:00
     * @fuction: about the role of function.
     * @param username
     */
    List<User> getUsersByUserName(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAll();

    /**
     * 根据id删除用户信息
     * @param id
     */
    void deleteById(Long id);
}
