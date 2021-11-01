package com.isms.ismsbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.dao.MachineTypeDao;
import com.isms.ismsbackend.entity.MachineType;
import com.isms.ismsbackend.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/28
 * 设备类型业务层实现类
 */
@Service
@Transactional
public class MachineTypeServiceImpl implements MachineTypeService {
    @Autowired
    private MachineTypeDao machineTypeDao;

    /**
     * 根据条件查询所有并分页
     * @param page 当前页
     * @param limit 每页条数
     * @param typeId 设备类型id
     * @return PageInfo
     */
    @Override
    public PageInfo findAll(Integer page,Integer limit,Integer typeId) {
        PageHelper.startPage(page,limit);
        List<MachineType> typeList = machineTypeDao.selectAll(typeId);
        PageInfo<MachineType> pageInfo = new PageInfo<>(typeList);
        return pageInfo;
    }

    /**
     * 根据id查询
     * @param typeId 设备类型id
     * @return MachineType
     */
    @Override
    public MachineType findById(Integer typeId) {
        MachineType machineType = machineTypeDao.selectByPrimaryKey(typeId);
        return machineType;
    }

    /**
     * 校验用户名
     * @param typeName 用户名称
     * @return MachineType
     */
    @Override
    public MachineType existsName(String typeName) {
        MachineType machineType = machineTypeDao.existsName(typeName);
        return machineType;
    }

    /**
     * 修改设备类型
     * @param machineType 修改的参数实体
     * @return 影响行数
     */
    @Override
    public Integer modifyMachineType(MachineType machineType) {
        return machineTypeDao.updateByPrimaryKeySelective(machineType);
    }

    /**
     * 根据id查询设备类型名称
     * @param typeId
     * @return MachineType
     */
    @Override
    public MachineType findByTypeId(Integer typeId) {
        MachineType machineType = machineTypeDao.selectByTypeId(typeId);
        return machineType;
    }

    /**
     * 逻辑删除
     * @param typeId
     * @return
     */
    @Override
    public Integer updateMachineType(Integer typeId) {
        MachineType machineType = machineTypeDao.selectByTypeId(typeId);
        //查到相关数据 执行返回0 逻辑删除失败
        if (machineType != null) {
            return 0;
        }
        return machineTypeDao.updateMachineType(typeId);
    }

    /**
     * 新增设备类型
     * @param machineType
     * @return
     */
    @Override
    public Integer addMachineType(MachineType machineType) {
        return  machineTypeDao.insertSelective(machineType);
    }

    /**
     * 查询所有设备类型名称
     * @return
     */
    @Override
    public List<MachineType> findMachineTypeNames() {
        return machineTypeDao.selectAlls();
    }
}
