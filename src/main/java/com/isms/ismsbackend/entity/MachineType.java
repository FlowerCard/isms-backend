package com.isms.ismsbackend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * machine_type
 * @author
 * 设备类型实体
 */
@Data
public class MachineType implements Serializable {
    /**
     * 设备类型
     */
    private Integer typeId;

    /**
     * 设备类型名称
     */
    private String typeName;

    /**
     * 是否删除   0：未删除   1：已删除
     */
    private Integer isDelete;



    private static final long serialVersionUID = 1L;
}