package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemAuth;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统权限VO")
@Data
public class SystemAuthDetailVO extends SystemAuth implements Serializable {

    private static final long serialVersionUID = -1319006216450409370L;
}
