package com.isms.ismsbackend.service;

import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.Worksite;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 工地业务层接口
 */
public interface WorksiteService {

    /**
     * 根据用户ID分页查询
     * @param page  当前页
     * @param limit 页大小
     * @param uid   用户ID
     * @return  封装的返回数据
     */
    public ResultVO queryAll(Integer uid, Integer page, Integer limit);

    /**
     * 根据工地ID查询
     * @param id 工地ID
     * @return 封装的返回数据
     */
    public ResultVO queryWorksiteById(Integer id);

    /**
     * 名字是否存在
     * @param workName 工地名称
     * @return 是否存在
     */
    public Boolean existsName(String workName);

    /**
     * 新增工地
     * @param worksite 工地对象
     * @return 封装的返回数据
     */
    public ResultVO addWorksite(Worksite worksite);

    /**
     * 修改工地
     * @param worksite 工地对象
     * @return 封装的返回数据
     */
    public ResultVO modifyWorksite(Worksite worksite);
    
}
