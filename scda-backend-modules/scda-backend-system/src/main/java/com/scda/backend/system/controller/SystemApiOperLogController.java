package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemApiOperLogService;
import com.scda.backend.api.system.dto.SystemApiOperLogCreateDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogDeleteDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogReadDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogUpdateDTO;
import com.scda.backend.api.system.vo.SystemApiOperLogDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统接口调用日志接口", tags = "系统接口调用日志接口")
@RestController
@RequestMapping("/systemApiOperLog")
public class SystemApiOperLogController {

    @Autowired
    private ISystemApiOperLogService systemApiOperLogService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemApiOperLogCreateDTO req) throws BusinessException {
        systemApiOperLogService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemApiOperLogReadDTO req) throws BusinessException {
        return Result.success(systemApiOperLogService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemApiOperLogReadDTO req) throws BusinessException {
        Page<SystemApiOperLogDetailVO> page = systemApiOperLogService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemApiOperLogUpdateDTO req) throws BusinessException {
        systemApiOperLogService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemApiOperLogDeleteDTO req) throws BusinessException {
        systemApiOperLogService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemApiOperLogReadDTO req) throws BusinessException {
        return Result.success(systemApiOperLogService.checkExists(req));
    }
}
