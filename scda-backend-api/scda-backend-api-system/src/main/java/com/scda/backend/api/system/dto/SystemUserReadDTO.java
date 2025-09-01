package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统用户DTO")
@Data
public class SystemUserReadDTO implements Serializable {

    private static final long serialVersionUID = -5187193912067371094L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String account;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 邮箱号
     */
    @ApiModelProperty("邮箱号")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
}
