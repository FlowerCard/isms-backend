package com.isms.ismsbackend.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

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