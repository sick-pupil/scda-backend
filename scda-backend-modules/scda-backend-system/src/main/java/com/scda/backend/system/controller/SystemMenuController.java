package com.scda.backend.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.system.ISystemMenuService;
import com.scda.backend.api.system.dto.SystemMenuCreateDTO;
import com.scda.backend.api.system.dto.SystemMenuDeleteDTO;
import com.scda.backend.api.system.dto.SystemMenuReadDTO;
import com.scda.backend.api.system.dto.SystemMenuUpdateDTO;
import com.scda.backend.api.system.vo.SystemMenuDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "系统菜单接口", tags = "系统菜单接口")
@RestController
@RequestMapping("/systemMenu")
public class SystemMenuController {

    @Autowired
    private ISystemMenuService systemMenuService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody SystemMenuCreateDTO req) throws BusinessException {
        systemMenuService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(SystemMenuReadDTO req) throws BusinessException {
        return Result.success(systemMenuService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(SystemMenuReadDTO req) throws BusinessException {
        Page<SystemMenuDetailVO> page = systemMenuService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody SystemMenuUpdateDTO req) throws BusinessException {
        systemMenuService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody SystemMenuDeleteDTO req) throws BusinessException {
        systemMenuService.delete(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(SystemMenuReadDTO req) throws BusinessException {
        return Result.success(systemMenuService.checkExists(req));
    }
}
