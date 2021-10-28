package com.isms.ismsbackend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 封装数据实体类
 */
@Data
public class City implements Serializable {
    /**
     * 区域id
     */
    private Integer cityId;

    /**
     * 区域名称
     */
    private String cityName;

    /**
     * 是否删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}