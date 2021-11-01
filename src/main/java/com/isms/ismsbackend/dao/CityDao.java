package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 封装数据实体类
 */
@Repository("cityDao")
public interface CityDao {
    int deleteByPrimaryKey(Integer cityId);

    /**
     * 逻辑删除
     * @param cityId 地区ID
     * @return 受影响行数
     */
    int setDelete(Integer cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer cityId);

    /**
     * 通过地区名称查询
     * @param cityName 地区名称
     * @return 地区对象
     */
    City selectByCityName(String cityName);

    /**
     * 模糊查询
     * @param searchName 模糊查询的名字
     * @param cityId 地区ID
     * @return 地区结果集合
     */
    List<City> selectAll(@Param("searchName") String searchName,@Param("cityId") Integer cityId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}