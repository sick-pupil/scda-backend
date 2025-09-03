package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemDictService;
import com.scda.backend.api.system.dto.SystemDictCreateDTO;
import com.scda.backend.api.system.dto.SystemDictDeleteDTO;
import com.scda.backend.api.system.dto.SystemDictReadDTO;
import com.scda.backend.api.system.dto.SystemDictUpdateDTO;
import com.scda.backend.api.system.vo.SystemDictDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统字典接口", tags="系统字典接口")
@RestController
@RequestMapping("/systemDict")
public class SystemDictController {

    @Autowired
    private ISystemDictService systemDictService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemDictCreateDTO req) throws BusinessException {
        systemDictService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemDictReadDTO req) throws BusinessException {
        return Result.success(systemDictService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemDictReadDTO req) throws BusinessException {
        Page<SystemDictDetailVO> page = systemDictService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemDictUpdateDTO req) throws BusinessException {
        systemDictService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemDictDeleteDTO req) throws BusinessException {
        systemDictService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemDictReadDTO req) throws BusinessException {
        return Result.success(systemDictService.checkExists(req));
    }
}
