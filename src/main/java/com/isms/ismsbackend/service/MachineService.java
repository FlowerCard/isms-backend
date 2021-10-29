package com.isms.ismsbackend.service;

import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.entity.Machine;
import org.springframework.beans.factory.annotation.Autowired;

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
    PageInfo findAll(Integer uId, Integer page, Integer limit);

    /**
     * 根据id查询
     * @param mid
     * @return
     */
    Machine findById(Integer mid);
}
