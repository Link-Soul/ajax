package com.link.service;

import com.link.pojo.User;

public interface UserService {
    User queryUserByName(String userName);
    int register(User user);
    User login(User user);
}
