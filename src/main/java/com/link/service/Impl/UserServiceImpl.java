package com.link.service.Impl;

import com.link.mapper.UserMapper;
import com.link.pojo.User;
import com.link.service.UserService;
import com.link.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    private SqlSession sqlSession = GetSqlSession.getSql();
    @Override
    public User queryUserByName(String userName){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(userName);
        return user;
    }

    @Override
    public int register(User user) {
        UserMapper u = sqlSession.getMapper(UserMapper.class);
        int register = u.register(user);
        sqlSession.commit();
        return register;
    }

    @Override
    public User login(User user) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.login(user);
        return user1;
    }


}
