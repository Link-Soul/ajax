package com.link.service;

import com.link.mapper.UserMapper;
import com.link.pojo.User;
import com.link.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    private SqlSession sqlSession = GetSqlSession.getSql();
    public User queryUserByName(String userName){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(userName);
        return user;
    };
}
