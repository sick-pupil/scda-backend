package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemUserService;
import com.scda.backend.api.system.dto.SystemUserCreateDTO;
import com.scda.backend.api.system.dto.SystemUserDeleteDTO;
import com.scda.backend.api.system.dto.SystemUserReadDTO;
import com.scda.backend.api.system.dto.SystemUserUpdateDTO;
import com.scda.backend.api.system.vo.SystemUserDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统用户接口", tags="系统用户接口")
@RestController
@RequestMapping("/systemUser")
public class SystemUserController {

    @Autowired
    private ISystemUserService systemUserService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemUserCreateDTO req) throws BusinessException {
        systemUserService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemUserReadDTO req) throws BusinessException {
        return Result.success(systemUserService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemUserReadDTO req) throws BusinessException {
        Page<SystemUserDetailVO> page = systemUserService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemUserUpdateDTO req) throws BusinessException {
        systemUserService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemUserDeleteDTO req) throws BusinessException {
        systemUserService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemUserReadDTO req) throws BusinessException {
        return Result.success(systemUserService.checkExists(req));
    }
}
