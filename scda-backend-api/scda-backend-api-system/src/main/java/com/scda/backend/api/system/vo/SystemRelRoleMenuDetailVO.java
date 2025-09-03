package com.scda.backend.api.system.vo;

import com.scda.backend.api.system.entity.SystemRelRoleMenu;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("系统角色菜单关联VO")
@Data
public class SystemRelRoleMenuDetailVO extends SystemRelRoleMenu implements Serializable {

    private static final long serialVersionUID = -8297676458944684879L;
}
