package com.isms.ismsbackend.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * machine
 * @author 
 */
@Data
@ApiModel(value = "Machine实体类",description = "对应数据库中Machine表，提供的字段到属性的映射")
public class Machine implements Serializable {
    /**
     * 设备id
     */
    @ApiModelProperty(value = "Machine的唯一标记")
    private Integer mId;

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String mName;

    /**
     * 是否在线   0:在线 1:不在线
     */
    @ApiModelProperty(value = "是否在线   0:在线 1:不在线")
    private Integer isOnline;

    /**
     * 是否启用 0：启用  1：未启用
     */
    @ApiModelProperty(value = "是否启用 0：启用  1：未启用")
    private Integer isEnable;

    /**
     * 此id跟工地表的id对应
     */
    @ApiModelProperty(value = "此id跟工地表的id对应")
    private Integer workId;

    /**
     * 此id跟设备类型表的id对应
     */
    @ApiModelProperty(value = "此id跟设备类型表的id对应")
    private Integer typeId;

    /**
     * 是否删除  0:未删除  1：已删除
     */
    @ApiModelProperty(value = "是否删除  0:未删除  1：已删除")
    private Integer isDelete;

    /**
     * 设备类型实体 方便联合查询
     */
    @ApiModelProperty(value = "设备类型实体 方便联合查询")
    private MachineType machineType;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    private Date updateDate;

    /**
     * 工地实体 方便联合查询
     */
    @ApiModelProperty(value = "User的唯一标记")
    private Worksite worksite;

    private static final long serialVersionUID = 1L;
}