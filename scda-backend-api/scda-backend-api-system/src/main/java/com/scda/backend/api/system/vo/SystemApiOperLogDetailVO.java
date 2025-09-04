package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemApiOperLog;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统接口调用日志VO")
@Data
public class SystemApiOperLogDetailVO extends SystemApiOperLog implements Serializable {

    private static final long serialVersionUID = 5730194674493307635L;
}
