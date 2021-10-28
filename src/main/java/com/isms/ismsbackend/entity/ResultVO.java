package com.isms.ismsbackend.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 封装数据实体类
 */
@Data
public class ResultVO implements Serializable {
    
    private static final long serialVersionUID = 42L;

    /**
     * 响应代码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;
}
