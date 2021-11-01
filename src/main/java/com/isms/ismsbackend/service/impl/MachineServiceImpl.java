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


    /**
     * 根据条件查询所有
     * @param uId 用户id
     * @param fuzzy 输入框的值
     * @param typeId 设备类型id
     * @param workId 工地id
     * @return Machine集合
     */
    @Override
    public PageInfo findAll(Integer uId, Integer page, Integer limit,String fuzzy,Integer typeId,Integer workId) {
        PageHelper.startPage(page,limit);
        List<Machine> machines = machineDao.selectAll(uId,fuzzy,typeId,workId);
        PageInfo<Machine> machinePageInfo = new PageInfo<>(machines);
        return machinePageInfo;
    }

    /**
     * 根据id查询
     * @param mid 设备id
     * @return Machine
     */
    @Override
    public Machine findById(Integer mid) {
        return machineDao.selectByPrimaryKey(mid);
    }

    /**
     * 查询所有的工地名称
     * @return List<Worksite>
     */
    @Override
    public List<Worksite> findWorksiteNames() {
        List<Worksite> worksites = worksiteDao.selectAll();
        return worksites;
    }

    /**
     * 校验设备名称
     * @param mName 设备名称
     * @return Machine
     */
    @Override
    public Machine existsName(String mName) {
        return machineDao.selectMachineName(mName);
    }

    /**
     * 修改设备
     * @param machine 分装设备数据的对象
     * @return 影响行数
     */
    @Override
    public Integer modifyMachine(Machine machine) {
        return machineDao.updateByPrimaryKeySelective(machine);
    }

    /**
     * 逻辑删除
     * @param mId 设备id
     * @return 影响行数
     */
    @Override
    public Integer removeMachine(Integer mId) {
        return machineDao.updateMachine(mId);
    }

    /**
     * 新增设备
     * @param machine 分装新增数据的对象
     * @return 影响行数
     */
    @Override
    public Integer addMachine(Machine machine) {
        return machineDao.insertSelective(machine);
    }
}
