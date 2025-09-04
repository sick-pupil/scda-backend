package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemUserLoginInfo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统用户登录信息VO")
@Data
public class SystemUserLoginInfoDetailVO extends SystemUserLoginInfo implements Serializable {

    private static final long serialVersionUID = -7616111099655115673L;
}
