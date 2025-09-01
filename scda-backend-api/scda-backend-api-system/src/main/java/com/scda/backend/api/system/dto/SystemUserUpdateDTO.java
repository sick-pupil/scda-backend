package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统用户DTO")
@Data
public class SystemUserUpdateDTO implements Serializable {

    private static final long serialVersionUID = 86277646847126565L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

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

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;
}
