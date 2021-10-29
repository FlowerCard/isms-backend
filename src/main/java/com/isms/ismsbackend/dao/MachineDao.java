package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.Machine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineDao {
    int deleteByPrimaryKey(Integer mId);

    int insert(Machine record);

    int insertSelective(Machine record);

    Machine selectByPrimaryKey(Integer mId);

    /**
     * 根据用户id查询所有
     * @param uId
     * @return
     */
    List<Machine> selectAll(Integer uId);

    int updateByPrimaryKeySelective(Machine record);

    int updateByPrimaryKey(Machine record);
}