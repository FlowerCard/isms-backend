package com.isms.ismsbackend.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 工地实体类
 */
@Data
@ApiModel(value = "工地实体类", description = "映射数据库中的工地表")
public class Worksite implements Serializable {
    /**
     * 工地id
     */
    @ApiModelProperty(value = "工地ID，自动生成")
    private Integer workId;

    /**
     * 工地名称
     */
    @ApiModelProperty(value = "工地名称")
    private String workName;

    /**
     * 工地地址
     */
    @ApiModelProperty(value = "工地地址")
    private String workAddr;

    /**
     * 此id跟地区ID对应
     */
    @ApiModelProperty(value = "地区ID")
    private Integer cityId;

    /**
     * 此id跟用户表id对应
     */
    @ApiModelProperty(value = "用户ID")
    private Integer uId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "工地创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "工地修改时间")
    private Date updateTime;

    /**
     * 是否删除  0:未删除  1:已删除
     */
    @ApiModelProperty(value = "删除状态，0:未删除，1:已删除")
    private Integer isDelete;

    /**
     * 地区对象
     */
    @ApiModelProperty(value = "地区对象，连表查询时封装查询到的地区数据")
    private City city;

    private static final long serialVersionUID = 1L;
}