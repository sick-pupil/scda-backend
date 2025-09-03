package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemRelRoleAuthService;
import com.scda.backend.api.system.dto.SystemRelRoleAuthCreateDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthReadDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelRoleAuthDetailVO;
import com.scda.backend.api.system.vo.SystemRelRoleMenuDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统角色权限关联接口", tags = "系统角色权限关联接口")
@RestController
@RequestMapping("/systemRelRoleAuth")
public class SystemRelRoleAuthController {

    @Autowired
    private ISystemRelRoleAuthService systemRelRoleAuthService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemRelRoleAuthCreateDTO req) throws BusinessException {
        systemRelRoleAuthService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemRelRoleAuthReadDTO req) throws BusinessException {
        return Result.success(systemRelRoleAuthService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemRelRoleAuthReadDTO req) throws BusinessException {
        Page<SystemRelRoleAuthDetailVO> page = systemRelRoleAuthService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemRelRoleAuthUpdateDTO req) throws BusinessException {
        systemRelRoleAuthService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemRelRoleAuthDeleteDTO req) throws BusinessException {
        systemRelRoleAuthService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemRelRoleAuthReadDTO req) throws BusinessException {
        return Result.success(systemRelRoleAuthService.checkExists(req));
    }
}
