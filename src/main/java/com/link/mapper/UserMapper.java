package com.link.mapper;

import com.link.pojo.User;

public interface UserMapper {
    User queryUserByName(String userName);
    int register(User user);
    User login(User user);

}
