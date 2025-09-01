package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemRoleService;
import com.scda.backend.api.system.dto.SystemRoleCreateDTO;
import com.scda.backend.api.system.dto.SystemRoleDeleteDTO;
import com.scda.backend.api.system.dto.SystemRoleReadDTO;
import com.scda.backend.api.system.dto.SystemRoleUpdateDTO;
import com.scda.backend.api.system.vo.SystemRoleDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统角色接口", tags="系统角色接口")
@RestController
@RequestMapping("/systemRole")
public class SystemRoleController {

    @Autowired
    private ISystemRoleService systemRoleService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemRoleCreateDTO req) throws BusinessException {
        systemRoleService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemRoleReadDTO req) throws BusinessException {
        return Result.success(systemRoleService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemRoleReadDTO req) throws BusinessException {
        Page<SystemRoleDetailVO> page = systemRoleService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemRoleUpdateDTO req) throws BusinessException {
        systemRoleService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemRoleDeleteDTO req) throws BusinessException {
        systemRoleService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemRoleReadDTO req) throws BusinessException {
        return Result.success(systemRoleService.checkExists(req));
    }
}
