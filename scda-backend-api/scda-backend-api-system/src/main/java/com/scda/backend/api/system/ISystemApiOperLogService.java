package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemApiOperLogCreateDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogDeleteDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogReadDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogUpdateDTO;
import com.scda.backend.api.system.vo.SystemApiOperLogDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemApiOperLog;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_api_oper_log(系统接口操作日志)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemApiOperLogService extends IService<SystemApiOperLog> {

    void create(SystemApiOperLogCreateDTO req) throws BusinessException;

    List<SystemApiOperLogDetailVO> read(SystemApiOperLogReadDTO req);

    Page<SystemApiOperLogDetailVO> readPage(SystemApiOperLogReadDTO req);

    Boolean checkExists(SystemApiOperLogReadDTO req) throws BusinessException;

    void update(SystemApiOperLogUpdateDTO req) throws BusinessException;

    void delete(SystemApiOperLogDeleteDTO req) throws BusinessException;
}
