package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.MachineType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MachineTypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(MachineType record);

    int insertSelective(MachineType record);

    MachineType selectByPrimaryKey(Integer typeId);

    List<MachineType> selectAll(@Param("typeId") Integer typeId);
    List<MachineType> selectAlls();

    MachineType existsName(String typeName);

    MachineType selectByTypeId(Integer typeId);

    /**
     * 逻辑删除
     * @param typeId
     * @return
     */
    Integer updateMachineType(Integer typeId);

    int updateByPrimaryKeySelective(MachineType record);

    int updateByPrimaryKey(MachineType record);
}