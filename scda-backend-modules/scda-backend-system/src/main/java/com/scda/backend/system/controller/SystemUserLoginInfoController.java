package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemUserLoginInfoService;
import com.scda.backend.api.system.dto.SystemUserLoginInfoCreateDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoDeleteDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoReadDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoUpdateDTO;
import com.scda.backend.api.system.vo.SystemUserLoginInfoDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统用户登录信息接口", tags="系统用户登录信息接口")
@RestController
@RequestMapping("/systemUserLoginInfo")
public class SystemUserLoginInfoController {

    @Autowired
    private ISystemUserLoginInfoService systemUserLoginInfoService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemUserLoginInfoCreateDTO req) throws BusinessException {
        systemUserLoginInfoService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemUserLoginInfoReadDTO req) throws BusinessException {
        return Result.success(systemUserLoginInfoService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemUserLoginInfoReadDTO req) throws BusinessException {
        Page<SystemUserLoginInfoDetailVO> page = systemUserLoginInfoService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemUserLoginInfoUpdateDTO req) throws BusinessException {
        systemUserLoginInfoService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemUserLoginInfoDeleteDTO req) throws BusinessException {
        systemUserLoginInfoService.delete(req);
        return Result.success();
    }
}
