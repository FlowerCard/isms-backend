package com.isms.ismsbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.dao.UserDao;
import com.isms.ismsbackend.entity.User;
import com.isms.ismsbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/28
 * 用户业务层实现类
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户登录方法
     * @param user 登录参数对象
     * @return 登录的用户信息
     */
    @Override
    public User login(User user) {
        //获取登录对象
        User findUser = userDao.selectUserByName(user.getUsername());
        //判断对象中的密码是否相等
        if (findUser.getPassword().equals(user.getPassword())) {
            return findUser;
        }
        return null;
    }

    /**
     * 根据条件查询所有用户
     * @param page 当前页数
     * @param limit 每页数据条数
     * @param fuzzy 输入框参数
     * @param isAdmin 用户身份id
     * @return 封装过的分页信息
     */
    @Override
    public PageInfo findAll(Integer page, Integer limit,String fuzzy,Integer isAdmin) {
        PageHelper.clearPage();
        //设置分页
        PageHelper.startPage(page,limit);
        List<User> userList = userDao.selectAll(fuzzy,isAdmin);
        log.info("userList ----> " + userList.toString() );
        log.debug("userList ----> " + userList.toString() );
        //设置分页分装数据
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

    /**
     * 根据用户id查询
     * @param uid 用户id
     * @return user对象
     */
    @Override
    public User findById(Integer uid) {
        User user = userDao.selectByPrimaryKey(uid);
        return user;
    }

    /**
     * 修改用户
     * @param user 修改的参数对象
     * @return 影响行数
     */
    @Override
    public Integer modifyUserById(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    /**
     * 逻辑删除用户
     * @param uid 用户id
     * @return 影响行数
     */
    @Override
    public Integer removeUserById(Integer uid) {
        return userDao.updateUser(uid);
    }

    /**
     * 新增用户
     * @param user 新增的用户对象
     * @return 影响行数
     */
    @Override
    public Integer addUser(User user) {
       return userDao.insertSelective(user);
    }

    /**
     * 校验用户名
     * @param userName 用户名
     * @return user对象
     */
    @Override
    public User existsName(String userName) {
        return userDao.selectUserByName(userName);
    }
}
