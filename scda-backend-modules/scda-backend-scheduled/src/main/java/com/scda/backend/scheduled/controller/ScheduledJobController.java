package com.scda.backend.scheduled.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.scheduled.IScheduledJobService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.vo.ScheduledJobDetailVO;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import com.scda.backend.common.core.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "定时任务接口", tags = "定时任务接口")
@RestController
@RequestMapping("/scheduledJob")
public class ScheduledJobController {

    @Autowired
    private IScheduledJobService scheduledJobService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@RequestBody ScheduledJobCreateDTO req) throws BusinessException {
        scheduledJobService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(ScheduledJobReadDTO req) {
        return Result.success(scheduledJobService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(ScheduledJobReadDTO req) {
        Page<ScheduledJobDetailVO> page = scheduledJobService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@RequestBody ScheduledJobUpdateDTO req) throws BusinessException {
        scheduledJobService.update(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @PutMapping("/checkExists")
    public Result checkExists(ScheduledJobReadDTO req) throws BusinessException {
        return Result.success(scheduledJobService.checkExists(req));
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@RequestBody ScheduledJobDeleteDTO req) throws BusinessException {
        scheduledJobService.delete(req);
        return Result.success();
    }

    @ApiOperation("绑定触发器")
    @PutMapping("/bindTrigger")
    public Result bindTrigger(@RequestBody ScheduledJobUpdateDTO req) throws BusinessException {
        scheduledJobService.bindTrigger(req);
        return Result.success();
    }

    @ApiOperation("启动")
    @PutMapping("/start")
    public Result start(@RequestBody ScheduledJobUpdateDTO req) throws BusinessException {
        scheduledJobService.start(req);
        return Result.success();
    }

    @ApiOperation("恢复")
    @PutMapping("/resume")
    public Result resume(@RequestBody ScheduledJobUpdateDTO req) throws BusinessException {
        scheduledJobService.resume(req);
        return Result.success();
    }

    @ApiOperation("暂停")
    @PutMapping("/pause")
    public Result pause(@RequestBody ScheduledJobUpdateDTO req) throws BusinessException {
        scheduledJobService.pause(req);
        return Result.success();
    }
}
