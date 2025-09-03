package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemDictDataService;
import com.scda.backend.api.system.dto.SystemDictDataCreateDTO;
import com.scda.backend.api.system.dto.SystemDictDataDeleteDTO;
import com.scda.backend.api.system.dto.SystemDictDataReadDTO;
import com.scda.backend.api.system.dto.SystemDictDataUpdateDTO;
import com.scda.backend.api.system.vo.SystemDictDataDetailVO;
import com.scda.backend.api.system.vo.SystemDictDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统字典数据接口", tags="系统字典数据接口")
@RestController
@RequestMapping("/systemDictData")
public class SystemDictDataController {

    @Autowired
    private ISystemDictDataService systemDictDataService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemDictDataCreateDTO req) throws BusinessException {
        systemDictDataService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemDictDataReadDTO req) throws BusinessException {
        return Result.success(systemDictDataService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemDictDataReadDTO req) throws BusinessException {
        Page<SystemDictDataDetailVO> page = systemDictDataService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemDictDataUpdateDTO req) throws BusinessException {
        systemDictDataService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemDictDataDeleteDTO req) throws BusinessException {
        systemDictDataService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemDictDataReadDTO req) throws BusinessException {
        return Result.success(systemDictDataService.checkExists(req));
    }
}
