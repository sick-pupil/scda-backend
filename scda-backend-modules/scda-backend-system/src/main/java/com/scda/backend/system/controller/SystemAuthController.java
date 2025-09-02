package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemAuthService;
import com.scda.backend.api.system.dto.SystemAuthCreateDTO;
import com.scda.backend.api.system.dto.SystemAuthDeleteDTO;
import com.scda.backend.api.system.dto.SystemAuthReadDTO;
import com.scda.backend.api.system.dto.SystemAuthUpdateDTO;
import com.scda.backend.api.system.vo.SystemAuthDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统权限接口", tags="系统权限接口")
@RestController
@RequestMapping("/systemAuth")
public class SystemAuthController {

    @Autowired
    private ISystemAuthService systemAuthService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemAuthCreateDTO req) throws BusinessException {
        systemAuthService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemAuthReadDTO req) throws BusinessException {
        return Result.success(systemAuthService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemAuthReadDTO req) throws BusinessException {
        Page<SystemAuthDetailVO> page = systemAuthService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemAuthUpdateDTO req) throws BusinessException {
        systemAuthService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemAuthDeleteDTO req) throws BusinessException {
        systemAuthService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemAuthReadDTO req) throws BusinessException {
        return Result.success(systemAuthService.checkExists(req));
    }
}
