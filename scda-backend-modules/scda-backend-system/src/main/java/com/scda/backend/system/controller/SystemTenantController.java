package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemTenantService;
import com.scda.backend.api.system.dto.SystemTenantCreateDTO;
import com.scda.backend.api.system.dto.SystemTenantDeleteDTO;
import com.scda.backend.api.system.dto.SystemTenantReadDTO;
import com.scda.backend.api.system.dto.SystemTenantUpdateDTO;
import com.scda.backend.api.system.vo.SystemTenantDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统租户接口", tags="系统租户接口")
@RestController
@RequestMapping("/systemTenant")
public class SystemTenantController {

    @Autowired
    private ISystemTenantService systemTenantService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemTenantCreateDTO req) throws BusinessException {
        systemTenantService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemTenantReadDTO req) throws BusinessException {
        return Result.success(systemTenantService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemTenantReadDTO req) throws BusinessException {
        Page<SystemTenantDetailVO> page = systemTenantService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemTenantUpdateDTO req) throws BusinessException {
        systemTenantService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemTenantDeleteDTO req) throws BusinessException {
        systemTenantService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemTenantReadDTO req) throws BusinessException {
        return Result.success(systemTenantService.checkExists(req));
    }
}
