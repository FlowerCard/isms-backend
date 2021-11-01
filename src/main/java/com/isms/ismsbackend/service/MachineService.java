package com.isms.ismsbackend.service;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.entity.Machine;
import com.isms.ismsbackend.entity.Worksite;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author lzj
 * @Date 2021/10/29
 * 设备业务层
 */
public interface MachineService {

    /**
     * 查询所有并分页
     * @param uId
     * @param page
     * @param limit
     * @return
     */
    PageInfo findAll(Integer uId, Integer page, Integer limit,String fuzzy,Integer typeId,Integer workId);

    /**
     * 根据id查询
     * @param mid
     * @return
     */
    Machine findById(Integer mid);

    /**
     * 查询工地名称
     * @return
     */
    List<Worksite> findWorksiteNames();

    /**
     * 修改设备
     * @param machine
     * @return
     */
    Integer modifyMachine(Machine machine);

    /**
     * 校验设备名称是否存在
     * @param mName
     * @return
     */
    Machine existsName(String mName);

    /**
     * 逻辑删除
     * @param mId
     * @return
     */
    Integer removeMachine(Integer mId);

    /**
     * 新增设备
     * @param machine
     * @return
     */
    Integer addMachine(Machine machine);
}
