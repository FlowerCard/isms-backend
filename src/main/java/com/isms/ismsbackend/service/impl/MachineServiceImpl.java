package com.isms.ismsbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.dao.MachineDao;
import com.isms.ismsbackend.dao.WorksiteDao;
import com.isms.ismsbackend.entity.Machine;
import com.isms.ismsbackend.entity.Worksite;
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

    @Autowired
    private WorksiteDao worksiteDao;


    @Override
    public PageInfo findAll(Integer uId, Integer page, Integer limit,String fuzzy,Integer typeId,Integer workId) {
        PageHelper.startPage(page,limit);
        List<Machine> machines = machineDao.selectAll(uId,fuzzy,typeId,workId);
        PageInfo<Machine> machinePageInfo = new PageInfo<>(machines);
        return machinePageInfo;
    }

    @Override
    public Machine findById(Integer mid) {
        return machineDao.selectByPrimaryKey(mid);
    }

    @Override
    public List<Worksite> findWorksiteNames() {
        List<Worksite> worksites = worksiteDao.selectAll();
        return worksites;
    }

    @Override
    public Machine existsName(String mName) {
        return machineDao.selectMachineName(mName);
    }

    @Override
    public Integer modifyMachine(Machine machine) {
        return machineDao.updateByPrimaryKeySelective(machine);
    }

    @Override
    public Integer removeMachine(Integer mId) {
        return machineDao.updateMachine(mId);
    }

    @Override
    public Integer addMachine(Machine machine) {
        return machineDao.insertSelective(machine);
    }
}
