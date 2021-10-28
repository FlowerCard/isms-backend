package com.isms.ismsbackend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份 0:员工 1:管理员
     */
    private Integer isAdmin;

    /**
     * 用户状态 0:未删除  1:已删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}