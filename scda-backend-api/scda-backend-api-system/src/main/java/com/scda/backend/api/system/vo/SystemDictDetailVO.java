package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemDict;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统字典VO")
@Data
public class SystemDictDetailVO extends SystemDict implements Serializable {

    private static final long serialVersionUID = -9011519212436573818L;
}
