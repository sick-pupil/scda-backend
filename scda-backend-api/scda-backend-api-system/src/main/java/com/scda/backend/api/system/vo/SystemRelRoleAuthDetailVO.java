package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemRelRoleAuth;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统角色权限关联VO")
@Data
public class SystemRelRoleAuthDetailVO extends SystemRelRoleAuth implements Serializable {

    private static final long serialVersionUID = -80921796305264026L;
}
