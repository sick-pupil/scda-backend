package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemRelDictData;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统字典数据关联VO")
@Data
public class SystemRelDictDataDetailVO extends SystemRelDictData implements Serializable {

    private static final long serialVersionUID = 1542134382403607429L;
}
