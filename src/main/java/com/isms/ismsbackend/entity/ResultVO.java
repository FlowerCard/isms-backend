package com.isms.ismsbackend.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/28.
 * 封装数据实体类
 */
@Data
@ApiModel(value = "执行结果实体类", description = "封装响应代码，响应信息，响应数据")
public class ResultVO implements Serializable {
    
    private static final long serialVersionUID = 42L;

    /**
     * 响应代码
     */
    @ApiModelProperty("响应代码")
    private Integer code;

    /**
     * 响应信息
     */
    @ApiModelProperty("响应信息")
    private String message;

    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    private Object data;
}
