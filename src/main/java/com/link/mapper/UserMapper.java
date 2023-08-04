package com.link.mapper;

import com.link.pojo.User;

public interface UserMapper {
    User queryUserByName(String userName);
}
