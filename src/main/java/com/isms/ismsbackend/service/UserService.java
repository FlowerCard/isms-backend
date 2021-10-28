package com.isms.ismsbackend.service;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.entity.User;

/**
 * @Author lzj
 * @Date 2021/10/28
 * 用户业务层
 */
public interface UserService {

    /**
     * 用户登录
     * @return
     */
    User login(User user);

    /**
     * 查询所有并分页
     * @return
     */
    PageInfo findAll(Integer page, Integer limit);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 修改用户
     * @return
     */
    Integer modifyUserById(User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    Integer removeUserById(Integer id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 校验用户名是否存在
     * @param userName
     * @return
     */
    User existsName(String userName);
}
