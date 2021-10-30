package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.Worksite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 工地持久层接口
 */
@Repository("worksiteDao")
public interface WorksiteDao {
    int deleteByPrimaryKey(Integer workId);

    /**
     * 逻辑删除
     * @param workId 工地id
     * @return 受影响行数
     */
    int setDelete(Integer workId);

    int insert(Worksite record);

    int insertSelective(Worksite record);

    Worksite selectByPrimaryKey(Integer workId);

    /**
     * 根据用户ID查询
     * @param uid 用户id
     * @return 对象结果集
     */
    List<Worksite> selectByUId(Integer uid);

    /**
     * 模糊搜索
     * @param uid       用户id
     * @param workName  工地名称
     * @param cityId    地区id
     * @return 对象结果集
     */
    List<Worksite> selectBySearch(@Param("u_id") Integer uid,@Param("work_name") String workName, @Param("city_id") Integer cityId);
    
    Worksite selectByWorkName(String username);

    /**
     * 根据地区ID查询工地数量
     * @param cityId 地区ID
     * @return 工地数量
     */
    int selectByCityId(Integer cityId);

    int updateByPrimaryKeySelective(Worksite record);

    int updateByPrimaryKey(Worksite record);
}