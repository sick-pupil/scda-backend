package com.scda.backend.system.controller;

import com.scda.backend.api.system.ISystemRelDictDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "系统字典数据关联接口", tags = "系统字典数据关联接口")
@RestController
@RequestMapping("/systemRelDictData")
public class SystemRelDictDataController {

    @Autowired
    private ISystemRelDictDataService systemRelDictDataService;
}
