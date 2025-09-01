package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemRole;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统角色VO")
@Data
public class SystemRoleDetailVO extends SystemRole implements Serializable {

    private static final long serialVersionUID = 1440446209686849989L;
}
