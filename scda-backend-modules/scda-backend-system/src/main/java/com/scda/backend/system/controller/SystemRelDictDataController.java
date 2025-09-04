package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemRelDictDataService;
import com.scda.backend.api.system.dto.SystemRelDictDataCreateDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataReadDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelDictDataDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统字典数据关联接口", tags = "系统字典数据关联接口")
@RestController
@RequestMapping("/systemRelDictData")
public class SystemRelDictDataController {

    @Autowired
    private ISystemRelDictDataService systemRelDictDataService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemRelDictDataCreateDTO req) throws BusinessException {
        systemRelDictDataService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemRelDictDataReadDTO req) throws BusinessException {
        return Result.success(systemRelDictDataService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemRelDictDataReadDTO req) throws BusinessException {
        Page<SystemRelDictDataDetailVO> page = systemRelDictDataService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemRelDictDataUpdateDTO req) throws BusinessException {
        systemRelDictDataService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemRelDictDataDeleteDTO req) throws BusinessException {
        systemRelDictDataService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemRelDictDataReadDTO req) throws BusinessException {
        return Result.success(systemRelDictDataService.checkExists(req));
    }
}
