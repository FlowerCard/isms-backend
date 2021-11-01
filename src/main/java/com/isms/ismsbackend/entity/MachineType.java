package com.isms.ismsbackend.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * machine_type
 * @author
 * 设备类型实体
 */
@Data
@ApiModel(value = "MachineType实体类",description = "对应数据库中MachineType表，提供的字段到属性的映射")
public class MachineType implements Serializable {
    /**
     * 设备类型
     */
    @ApiModelProperty(value = "MachineTyp的唯一标记")
    private Integer typeId;

    /**
     * 设备类型名称
     */
    @ApiModelProperty(value = "设备类型名称")
    private String typeName;

    /**
     * 是否删除   0：未删除   1：已删除
     */
    @ApiModelProperty(value = "是否删除   0：未删除   1：已删除")
    private Integer isDelete;

    @ApiModelProperty(value = "设备实体类")
    private Machine machine;

    private static final long serialVersionUID = 1L;
}