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

    /**
     * 根据条件查询所有
     * @param typeId 设备类型id
     * @return 设备类型集合
     */
    List<MachineType> selectAll(@Param("typeId") Integer typeId);

    /**
     * 查询所有设备类型的名称
     * @return
     */
    List<MachineType> selectAlls();

    /**
     * 校验设备名
     * @param typeName 设备类型名称
     * @return MachineType
     */
    MachineType existsName(String typeName);

    /**
     * 根据id查询设备类型名称
     * @param typeId 设备类型id
     * @return MachineType
     */
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