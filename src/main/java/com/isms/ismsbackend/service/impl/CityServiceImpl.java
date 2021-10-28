package com.isms.ismsbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isms.ismsbackend.constant.MessageConstant;
import com.isms.ismsbackend.constant.ResponseCode;
import com.isms.ismsbackend.dao.CityDao;
import com.isms.ismsbackend.entity.City;
import com.isms.ismsbackend.entity.ResultVO;
import com.isms.ismsbackend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 地区业务层实现类
 */
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
    
    @Autowired
    private CityDao cityDao;
    
    private ResultVO resultVO = null;

    /**
     * 查询所有地区
     * @param page  当前页
     * @param limit 页大小
     * @return 封装的分页数据
     */
    @Override
    public ResultVO queryAllCities(Integer page, Integer limit) {
        // 判断传入的分页数据是否合理
        if (page == 0 || page == null) {
            page = 1;
        }

        if (limit == 0 || limit == null) {
            limit = 10;
        }
        
        resultVO = new ResultVO();
        // 开启分页
        PageHelper.startPage(page,limit);
        List<City> queryCities = cityDao.selectAll();
        
        // 如果数据为空则返回 null
        if (queryCities.size() == 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.QUERY_FAIL);
            resultVO.setData(null);
            return resultVO;
        }

        // 封装数据进行分页
        PageInfo pageInfo = new PageInfo(queryCities);
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(pageInfo);
        
        return resultVO;
    }

    /**
     * 根据地区ID查询
     *
     * @param cityId 地区ID
     * @return 封装的地区数据
     */
    @Override
    public ResultVO queryById(Integer cityId) {
        resultVO = new ResultVO();
        City city = cityDao.selectByPrimaryKey(cityId);
        
        // 对象为空
        if (city == null) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.QUERY_FAIL);
            resultVO.setData(null);
            return resultVO;
        }
        
        // 对象不为空
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(city);
        return resultVO;
    }

    /**
     * 修改地区
     *
     * @param city 地区对象
     * @return 是否成功
     */
    @Override
    public ResultVO modifyCity(City city) {
        int row = cityDao.updateByPrimaryKeySelective(city);
        resultVO = new ResultVO();
        if (row != 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.UPDATE_SUCCESS);
            resultVO.setData(null);
            return resultVO;
        } else {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.UPDATE_FAIL);
            resultVO.setData(null);
            return resultVO;
        }
    }

    /**
     * 新增地区
     *
     * @param city 地区对象
     * @return 是否成功
     */
    @Override
    public ResultVO addCity(City city) {
        resultVO = new ResultVO();
        //如果对象为空
        if (city.getCityName() == null || city.getCityName().trim().length() == 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.ADD_FAIL);
            resultVO.setData(null);
            return resultVO;
        }
        
        int row = cityDao.insertSelective(city);
        if (row != 0) {
            resultVO.setCode(ResponseCode.SUCCESS);
            resultVO.setMessage(MessageConstant.UPDATE_SUCCESS);
            resultVO.setData(null);
            return resultVO;
        } else {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.UPDATE_FAIL);
            resultVO.setData(null);
            return resultVO;
        }
    }

    /**
     * 名字是否存在
     *
     * @param cityName 地区名字
     * @return 是否存在
     */
    @Override
    public Boolean existsName(String cityName) {
        City city = cityDao.selectByCityName(cityName);
        return city == null;
    }

    /**
     * 删除地区
     *
     * @param cityId 地区Id
     * @return 是否成功
     */
    @Override
    public Boolean removeCity(Integer cityId) {
        int row = cityDao.setDelete(cityId);
        return row != 0;
    }
}
