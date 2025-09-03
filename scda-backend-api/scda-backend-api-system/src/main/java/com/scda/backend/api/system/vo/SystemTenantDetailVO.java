package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemTenant;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统租户VO")
@Data
public class SystemTenantDetailVO extends SystemTenant implements Serializable {

    private static final long serialVersionUID = 8553430671973282919L;
}
