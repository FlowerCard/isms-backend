package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.Machine;
import org.apache.ibatis.annotations.Param;
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
    List<Machine> selectAll(@Param("uId") Integer uId,@Param("fuzzy") String fuzzy,
                            @Param("typeId") Integer typeId,@Param("workId") Integer workId);

    /**
     * 根据设备名查询 用于校验设备名是否存在
     * @param mName
     * @return
     */
    Machine selectMachineName(String mName);

    /**
     * 逻辑删除
     * @param mId
     * @return
     */
    int updateMachine(Integer mId);

    int updateByPrimaryKeySelective(Machine record);

    int updateByPrimaryKey(Machine record);
}