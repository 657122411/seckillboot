package com.tjh.seckill.service;

import com.tjh.seckill.dao.UserDao;
import com.tjh.seckill.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getByid(int id){
        return userDao.getById(id);
    }
}
