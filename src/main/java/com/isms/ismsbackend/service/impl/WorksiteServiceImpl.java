package com.isms.ismsbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.dao.MachineDao;
import com.isms.ismsbackend.dao.WorksiteDao;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.entity.Worksite;
import com.isms.ismsbackend.service.WorksiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 工地业务层实现
 */
@Service("worksiteService")
public class WorksiteServiceImpl implements WorksiteService {
    
    @Autowired
    private WorksiteDao worksiteDao;
    
    @Autowired
    private MachineDao machineDao;
    
    private ResultVO resultVO = null;

    /**
     * 根据用户ID分页查询
     * 
     * @param page  当前页
     * @param limit 页大小
     * @param uid   用户ID
     * @param workName 工地名称
     * @param cityId 工地ID
     * @return  封装的返回数据
     */
    @Override
    public ResultVO queryAll(Integer uid, Integer page, Integer limit, String workName, Integer cityId) {
        resultVO = new ResultVO();
        
        if (page == 0) {
            page = 1;
        }

        if (limit == 0) {
            limit = 10;
        }

        PageHelper.startPage(page,limit);
        List<Worksite> worksites = worksiteDao.selectBySearch(uid, workName, cityId);
        if (worksites.size() == 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.QUERY_FAIL);
            resultVO.setData(null);
            return resultVO;
        }

        PageInfo pageInfo = new PageInfo(worksites);
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(pageInfo);
        return resultVO;
    }

    /**
     * 根据工地ID查询
     *
     * @param id 工地ID
     * @return 封装的返回数据
     */
    @Override
    public ResultVO queryWorksiteById(Integer id) {
        resultVO = new ResultVO();
        Worksite worksite = worksiteDao.selectByPrimaryKey(id);
        if (worksite == null) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.QUERY_FAIL);
            resultVO.setData(null);
            return resultVO;
        }
        
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(worksite);
        return resultVO;
    }

    /**
     * 名字是否存在
     *
     * @param workName 工地名称
     * @return 是否存在
     */
    @Override
    public Boolean existsName(String workName) {
        Worksite worksite = worksiteDao.selectByWorkName(workName);
        return worksite == null;
    }

    /**
     * 新增工地
     *
     * @param worksite 工地对象
     * @return 封装的返回数据
     */
    @Override
    public ResultVO addWorksite(Worksite worksite) {
        worksite.setCreateTime(new Date());
        int row = worksiteDao.insertSelective(worksite);
        resultVO = new ResultVO();
        if (row == 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.ADD_FAIL);
            resultVO.setData(false);
            return resultVO;
        }
        
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.ADD_SUCCESS);
        resultVO.setData(true);
        return resultVO;
    }

    /**
     * 修改工地
     *
     * @param worksite 工地对象
     * @return 封装的返回数据
     */
    @Override
    public ResultVO modifyWorksite(Worksite worksite) {
        resultVO = new ResultVO();
        worksite.setUpdateTime(new Date());
        int row = worksiteDao.updateByPrimaryKeySelective(worksite);
        if (row == 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.UPDATE_FAIL);
            resultVO.setData(false);
            return resultVO;
        }
        
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.UPDATE_SUCCESS);
        resultVO.setData(true);
        return resultVO;
    }

    /**
     * 删除工地
     *
     * @param workId 工地ID
     * @return 封装的返回数据
     */
    @Override
    public ResultVO removeWorksite(Integer workId) {
        resultVO = new ResultVO();
        // 查询被删除的工地下是否有设备
        int count = machineDao.selectByWorkId(workId);
        if (count != 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.DELETE_FAIL);
            resultVO.setData(false);
            return resultVO;
        }
        // 没有设备执行逻辑删除
        int row = worksiteDao.setDelete(workId);
        if (row == 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.DELETE_FAIL);
            resultVO.setData(false);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.DELETE_SUCCESS);
        resultVO.setData(true);
        return resultVO;
    }
}
