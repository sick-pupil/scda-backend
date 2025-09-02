package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemMenu;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统菜单VO")
@Data
public class SystemMenuDetailVO extends SystemMenu implements Serializable {

    private static final long serialVersionUID = -2140905868219832461L;
}
