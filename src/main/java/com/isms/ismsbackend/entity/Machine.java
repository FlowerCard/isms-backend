package com.isms.ismsbackend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * machine
 * @author 
 */
@Data
public class Machine implements Serializable {
    /**
     * 设备id
     */
    private Integer mId;

    /**
     * 设备名称
     */
    private String mName;

    /**
     * 是否在线   0:在线 1:不在线
     */
    private Integer isOnline;

    /**
     * 是否启用 0：启用  1：未启用
     */
    private Integer isEnable;

    /**
     * 此id跟工地表的id对应
     */
    private Integer workId;

    /**
     * 此id跟设备类型表的id对应
     */
    private Integer typeId;

    /**
     * 是否删除  0:未删除  1：已删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}