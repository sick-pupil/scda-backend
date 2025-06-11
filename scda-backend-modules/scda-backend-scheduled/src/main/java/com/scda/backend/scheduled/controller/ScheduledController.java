package com.scda.backend.scheduled.controller;

import com.scda.backend.api.scheduled.IScheduledService;
import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.domain.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduled")
public class ScheduledController {

    @Autowired
    private IScheduledService scheduledService;

    @PostMapping("/createJob")
    public Result createJob() {
        return Result.success();
    }

    @GetMapping("/readJobs")
    public Table readJobs() {
        return Table.success();
    }

    @PutMapping("/updateJob")
    public Result updateJob() {
        return Result.success();
    }

    @DeleteMapping("/deleteJob")
    public Result deleteJob() {
        return Result.success();
    }

    @PutMapping("/startJob")
    public Result startJob() {
        return Result.success();
    }

    @PutMapping("/resumeJob")
    public Result resumeJob() {
        return Result.success();
    }

    @PutMapping("/pauseJob")
    public Result pauseJob() {
        return Result.success();
    }
}
