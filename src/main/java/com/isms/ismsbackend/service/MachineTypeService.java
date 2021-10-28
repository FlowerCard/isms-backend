package com.isms.ismsbackend.service;

import com.github.pagehelper.PageInfo;

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
    PageInfo findAll(Integer page,Integer limit);
}
