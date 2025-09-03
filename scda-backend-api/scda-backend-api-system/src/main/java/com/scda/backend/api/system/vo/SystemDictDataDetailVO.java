package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemDictData;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统字典数据VO")
@Data
public class SystemDictDataDetailVO extends SystemDictData implements Serializable {

    private static final long serialVersionUID = 7339158692097099309L;
}
