package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel("创建系统用户DTO")
@Data
public class SystemUserCreateDTO implements Serializable {

    private static final long serialVersionUID = 5214614453255091318L;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    @NotBlank(message = "账号非空")
    private String account;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名非空")
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
    @NotBlank(message = "密码非空")
    private String password;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;
}
