package com.isms.ismsbackend.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
@ApiModel(value = "User实体类",description = "对应数据库中user表，提供的字段到属性的映射")
public class User implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "User的唯一标记")
    private Integer uId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 身份 0:员工 1:管理员
     */
    @ApiModelProperty(value = "身份 0:员工 1:管理员")
    private Integer isAdmin;

    /**
     * 用户状态 0:未删除  1:已删除
     */
    @ApiModelProperty(value = "用户状态 0:未删除  1:已删除")
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}