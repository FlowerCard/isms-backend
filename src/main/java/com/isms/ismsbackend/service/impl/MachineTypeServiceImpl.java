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
    public PageInfo findAll(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<MachineType> typeList = machineTypeDao.selectAll();
        PageInfo<MachineType> pageInfo = new PageInfo<>(typeList);
        return pageInfo;
    }
}
