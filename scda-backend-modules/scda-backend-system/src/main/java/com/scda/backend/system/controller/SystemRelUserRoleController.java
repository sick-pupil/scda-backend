package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemRelUserRoleService;
import com.scda.backend.api.system.dto.SystemRelUserRoleCreateDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleReadDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelUserRoleDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统用户角色关联接口", tags = "系统用户角色关联接口")
@RestController
@RequestMapping("/systemRelUserRole")
public class SystemRelUserRoleController {

    @Autowired
    private ISystemRelUserRoleService systemRelUserRoleService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemRelUserRoleCreateDTO req) throws BusinessException {
        systemRelUserRoleService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemRelUserRoleReadDTO req) throws BusinessException {
        return Result.success(systemRelUserRoleService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemRelUserRoleReadDTO req) throws BusinessException {
        Page<SystemRelUserRoleDetailVO> page = systemRelUserRoleService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemRelUserRoleUpdateDTO req) throws BusinessException {
        systemRelUserRoleService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemRelUserRoleDeleteDTO req) throws BusinessException {
        systemRelUserRoleService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemRelUserRoleReadDTO req) throws BusinessException {
        return Result.success(systemRelUserRoleService.checkExists(req));
    }
}
