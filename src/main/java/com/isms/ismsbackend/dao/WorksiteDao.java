package com.isms.ismsbackend.dao;

import com.isms.ismsbackend.entity.Worksite;
import org.springframework.stereotype.Repository;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 工地持久层接口
 */
@Repository("worksiteDao")
public interface WorksiteDao {
    int deleteByPrimaryKey(Integer workId);

    int insert(Worksite record);

    int insertSelective(Worksite record);

    Worksite selectByPrimaryKey(Integer workId);

    int updateByPrimaryKeySelective(Worksite record);

    int updateByPrimaryKey(Worksite record);
}