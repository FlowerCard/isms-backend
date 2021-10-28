package com.isms.ismsbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.dao.UserDao;
import com.isms.ismsbackend.entity.User;
import com.isms.ismsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/28
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User user1 = userDao.selectUserByName(user.getUsername());
        if (user1.getPassword().equals(user.getPassword())) {
            return user1;
        }
        return null;
    }

    @Override
    public PageInfo findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<User> userList = userDao.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

    @Override
    public User findById(Integer uid) {
        User user = userDao.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public Integer modifyUserById(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer removeUserById(Integer uid) {
        return userDao.updateUser(uid);
    }

    @Override
    public Integer addUser(User user) {
       return userDao.insertSelective(user);
    }

    @Override
    public User existsName(String userName) {
        return userDao.selectUserByName(userName);
    }
}
