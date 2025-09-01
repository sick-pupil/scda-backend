package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemUser;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统用户VO")
@Data
public class SystemUserDetailVO extends SystemUser implements Serializable {

    private static final long serialVersionUID = -2998665035602806265L;
}
