package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    /**
     * 根据条件查询所有
     * @param fuzzy 输入框的值
     * @param uid 用户id
     * @return user集合
     */
    List<User> selectAll(@Param("fuzzy") String fuzzy, @Param("uid") Integer uid);

    /**
     * 校验用户名
     * @param name 用户名
     * @return user对象
     */
    User selectUserByName(String name);

    /**
     * 逻辑删除
     * @param uid 用户id
     * @return 影响行数
     */
    int updateUser(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}