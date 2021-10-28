package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.Machine;

public interface MachineDao {
    int deleteByPrimaryKey(Integer mId);

    int insert(Machine record);

    int insertSelective(Machine record);

    Machine selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Machine record);

    int updateByPrimaryKey(Machine record);
}