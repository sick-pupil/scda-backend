package com.scda.backend.scheduled.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.scheduled.IScheduledTriggersService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.vo.ScheduledTriggersDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "定时任务触发器接口", tags = "定时任务触发器接口")
@RestController
@RequestMapping("/scheduledTrigger")
public class ScheduledTriggersController {

    @Autowired
    private IScheduledTriggersService scheduledTriggersService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@Valid @RequestBody ScheduledTriggersCreateDTO req) throws BusinessException {
        scheduledTriggersService.create(req);
        return Result.success();
    }

    @ApiOperation("转换trigger")
    @GetMapping("/transfer2Trigger")
    public Result transfer2Trigger(ScheduledTriggersReadDTO req) throws BusinessException {
        return Result.success(scheduledTriggersService.transfer2Trigger(req));
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(ScheduledTriggersReadDTO req) {
        return Result.success(scheduledTriggersService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(ScheduledTriggersReadDTO req) {
        Page<ScheduledTriggersDetailVO> page = scheduledTriggersService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@Valid @RequestBody ScheduledTriggersUpdateDTO req) throws BusinessException {
        scheduledTriggersService.update(req);
        return Result.success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@Valid @RequestBody ScheduledTriggersDeleteDTO req) throws BusinessException {
        scheduledTriggersService.delete(req);
        return Result.success();
    }
}
