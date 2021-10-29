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

    @Override
    public PageInfo findAll(Integer page,Integer limit,Integer typeId) {
        PageHelper.startPage(page,limit);
        List<MachineType> typeList = machineTypeDao.selectAll(typeId);
        PageInfo<MachineType> pageInfo = new PageInfo<>(typeList);
        return pageInfo;
    }

    @Override
    public MachineType findById(Integer typeId) {
        MachineType machineType = machineTypeDao.selectByPrimaryKey(typeId);
        return machineType;
    }

    @Override
    public MachineType existsName(String typeName) {
        MachineType machineType = machineTypeDao.existsName(typeName);
        return machineType;
    }

    @Override
    public Integer modifyMachineType(MachineType machineType) {
        return machineTypeDao.updateByPrimaryKeySelective(machineType);
    }

    @Override
    public MachineType findByTypeId(Integer typeId) {
        MachineType machineType = machineTypeDao.selectByTypeId(typeId);
        return machineType;
    }

    @Override
    public Integer updateMachineType(Integer typeId) {
        MachineType machineType = machineTypeDao.selectByTypeId(typeId);
        //查到相关数据 执行返回0 逻辑删除失败
        if (machineType != null) {
            return 0;
        }
        return machineTypeDao.updateMachineType(typeId);
    }

    @Override
    public Integer addMachineType(MachineType machineType) {
        return  machineTypeDao.insertSelective(machineType);
    }

    @Override
    public List<MachineType> findMachineTypeNames() {
        return machineTypeDao.selectAlls();
    }
}
