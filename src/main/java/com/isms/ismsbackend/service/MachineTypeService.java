package com.isms.ismsbackend.service;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.entity.MachineType;

import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/28
 * 设备类型业务层
 */
public interface MachineTypeService {

    /**
     * 查询所有并分页
     * @return
     */
    PageInfo findAll(Integer page,Integer limit,Integer typeId);

    /**
     * 根据id查询
     * @param typeId
     * @return
     */
    MachineType findById(Integer typeId);

    /**
     * 校验类型名称
     * @param typeName
     * @return
     */
    MachineType existsName(String typeName);

    /**
     * 修改设备类型
     * @param machineType
     * @return
     */
    Integer modifyMachineType(MachineType machineType);

    /**
     * 根据id查询设备类型名称
     * @param typeId
     * @return
     */
    MachineType findByTypeId(Integer typeId);

    /**
     * 逻辑删除
     * @param typeId
     * @return
     */
    Integer updateMachineType (Integer typeId);

    /**
     * 新增设备
     * @param machineType
     * @return
     */
    Integer addMachineType(MachineType machineType);

    /**
     * 查询设备类型名称
     * @return
     */
    List<MachineType> findMachineTypeNames();
}
