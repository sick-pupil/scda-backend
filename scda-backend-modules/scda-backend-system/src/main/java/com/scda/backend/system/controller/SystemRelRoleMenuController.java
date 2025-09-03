package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemRelRoleMenuService;
import com.scda.backend.api.system.dto.SystemRelRoleMenuCreateDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuReadDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelRoleMenuDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统角色菜单关联接口", tags = "系统角色菜单关联接口")
@RestController
@RequestMapping("/systemRelRoleMenu")
public class SystemRelRoleMenuController {

    @Autowired
    private ISystemRelRoleMenuService systemRelRoleMenuService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemRelRoleMenuCreateDTO req) throws BusinessException {
        systemRelRoleMenuService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemRelRoleMenuReadDTO req) throws BusinessException {
        return Result.success(systemRelRoleMenuService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemRelRoleMenuReadDTO req) throws BusinessException {
        Page<SystemRelRoleMenuDetailVO> page = systemRelRoleMenuService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemRelRoleMenuUpdateDTO req) throws BusinessException {
        systemRelRoleMenuService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemRelRoleMenuDeleteDTO req) throws BusinessException {
        systemRelRoleMenuService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemRelRoleMenuReadDTO req) throws BusinessException {
        return Result.success(systemRelRoleMenuService.checkExists(req));
    }
}
