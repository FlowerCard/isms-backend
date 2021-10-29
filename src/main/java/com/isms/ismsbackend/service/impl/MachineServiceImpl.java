package com.isms.ismsbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.dao.MachineDao;
import com.isms.ismsbackend.entity.Machine;
import com.isms.ismsbackend.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/29
 * 设备业务层实现类
 */
@Service
@Transactional
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineDao machineDao;


    @Override
    public PageInfo findAll(Integer uId, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Machine> machines = machineDao.selectAll(uId);
        PageInfo<Machine> machinePageInfo = new PageInfo<>(machines);
        return machinePageInfo;
    }

    @Override
    public Machine findById(Integer mid) {
        return machineDao.selectByPrimaryKey(mid);
    }
}
