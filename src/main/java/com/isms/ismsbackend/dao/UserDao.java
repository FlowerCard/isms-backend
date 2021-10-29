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

    List<User> selectAll(@Param("fuzzy") String fuzzy, @Param("uid") Integer uid);

    User selectUserByName(String name);

    int updateUser(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}