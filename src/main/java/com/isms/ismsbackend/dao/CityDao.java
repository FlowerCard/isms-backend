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

    int setDelete(Integer cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer cityId);
    
    City selectByCityName(String cityName);
    
    List<City> selectAll(@Param("searchName") String searchName,@Param("cityId") Integer cityId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}