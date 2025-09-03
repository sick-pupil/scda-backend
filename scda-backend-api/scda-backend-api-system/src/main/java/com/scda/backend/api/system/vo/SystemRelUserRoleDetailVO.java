package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemRelUserRole;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统用户角色关联VO")
@Data
public class SystemRelUserRoleDetailVO extends SystemRelUserRole implements Serializable {

    private static final long serialVersionUID = 7286339535641479740L;
}
