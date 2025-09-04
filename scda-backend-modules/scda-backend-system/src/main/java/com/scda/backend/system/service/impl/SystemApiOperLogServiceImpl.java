package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemApiOperLogCreateDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogDeleteDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogReadDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogUpdateDTO;
import com.scda.backend.api.system.vo.SystemApiOperLogDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemApiOperLog;
import com.scda.backend.api.system.ISystemApiOperLogService;
import com.scda.backend.system.mapper.SystemApiOperLogMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_api_oper_log(系统接口操作日志)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemApiOperLogServiceImpl extends ServiceImpl<SystemApiOperLogMapper, SystemApiOperLog>
    implements ISystemApiOperLogService{

    @Override
    public void create(SystemApiOperLogCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemApiOperLogDetailVO> read(SystemApiOperLogReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemApiOperLogDetailVO> readPage(SystemApiOperLogReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemApiOperLogReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemApiOperLogUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemApiOperLogDeleteDTO req) throws BusinessException {

    }
}




