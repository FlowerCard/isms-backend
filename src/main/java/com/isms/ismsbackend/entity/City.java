package com.isms.ismsbackend.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 封装数据实体类
 */
@Data
@ApiModel(value = "地区实体类", description = "映射数据库中的地区表")
public class City implements Serializable {
    /**
     * 区域id
     */
    @ApiModelProperty(value = "地区ID，自动生成")
    private Integer cityId;

    /**
     * 区域名称
     */
    @ApiModelProperty(value = "地区名称")
    private String cityName;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "删除状态，0:未删除，1:已删除")
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}