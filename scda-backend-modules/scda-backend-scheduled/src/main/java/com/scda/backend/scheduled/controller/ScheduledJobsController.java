package com.scda.backend.scheduled.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scda.backend.api.scheduled.IScheduledJobsService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.vo.ScheduledJobsDetailVO;
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
public class ScheduledJobsController {

    @Autowired
    private IScheduledJobsService scheduledJobService;

    @ApiOperation("创建")
    @PostMapping("/create")
    public Result create(@RequestBody ScheduledJobsCreateDTO req) throws BusinessException {
        scheduledJobService.create(req);
        return Result.success();
    }

    @ApiOperation("查询列表")
    @GetMapping("/read")
    public Result read(ScheduledJobsReadDTO req) {
        return Result.success(scheduledJobService.read(req));
    }

    @ApiOperation("查询分页列表")
    @GetMapping("/readPage")
    public Table readPage(ScheduledJobsReadDTO req) {
        Page<ScheduledJobsDetailVO> page = scheduledJobService.readPage(req);
        return Table.success(page.getRecords(), page.getTotal());
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public Result update(@RequestBody ScheduledJobsUpdateDTO req) throws BusinessException {
        scheduledJobService.update(req);
        return Result.success();
    }

    @ApiOperation("是否存在")
    @GetMapping("/checkExists")
    public Result checkExists(ScheduledJobsReadDTO req) throws BusinessException {
        return Result.success(scheduledJobService.checkExists(req));
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public Result delete(@RequestBody ScheduledJobsDeleteDTO req) throws BusinessException {
        scheduledJobService.delete(req);
        return Result.success();
    }

    @ApiOperation("绑定触发器")
    @PutMapping("/bindTrigger")
    public Result bindTrigger(@RequestBody ScheduledJobsUpdateDTO req) throws BusinessException {
        scheduledJobService.bindTrigger(req);
        return Result.success();
    }

    @ApiOperation("解绑触发器")
    @PutMapping("/unBindTrigger")
    public Result unBindTrigger(@RequestBody ScheduledJobsUpdateDTO req) throws BusinessException {
        scheduledJobService.unBindTrigger(req);
        return Result.success();
    }

    @ApiOperation("恢复")
    @PutMapping("/resume")
    public Result resume(@RequestBody ScheduledJobsUpdateDTO req) throws BusinessException {
        scheduledJobService.resume(req);
        return Result.success();
    }

    @ApiOperation("暂停")
    @PutMapping("/pause")
    public Result pause(@RequestBody ScheduledJobsUpdateDTO req) throws BusinessException {
        scheduledJobService.pause(req);
        return Result.success();
    }
}
