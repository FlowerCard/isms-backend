package com.isms.ismsbackend.service;

import com.isms.ismsbackend.entity.City;
import com.isms.ismsbackend.entity.ResultVO;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 地区业务层接口
 */
public interface CityService {

    /**
     * 查询所有地区
     * @param page  当前页
     * @param limit 页大小
     * @return 封装的分页数据
     */
    public ResultVO queryAllCities(Integer page, Integer limit);

    /**
     * 根据地区ID查询
     * @param cityId 地区ID
     * @return 封装的地区数据
     */
    public ResultVO queryById(Integer cityId);

    /**
     * 修改地区
     * @param city 地区对象
     * @return 是否成功
     */
    public ResultVO modifyCity(City city);

    /**
     * 新增地区
     * @param city 地区对象
     * @return 是否成功
     */
    public ResultVO addCity(City city);

    /**
     * 名字是否存在
     * @param cityName 地区名字
     * @return 是否存在
     */
    public Boolean existsName(String cityName);

    /**
     * 删除地区
     * @param cityId 地区Id
     * @return 是否成功
     */
    public Boolean removeCity(Integer cityId);
    
}
