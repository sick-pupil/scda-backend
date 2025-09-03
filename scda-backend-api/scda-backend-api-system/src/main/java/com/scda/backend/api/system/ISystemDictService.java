package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemDictCreateDTO;
import com.scda.backend.api.system.dto.SystemDictDeleteDTO;
import com.scda.backend.api.system.dto.SystemDictReadDTO;
import com.scda.backend.api.system.dto.SystemDictUpdateDTO;
import com.scda.backend.api.system.vo.SystemDictDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemDict;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_dict(系统字典)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemDictService extends IService<SystemDict> {

    void create(SystemDictCreateDTO req) throws BusinessException;

    List<SystemDictDetailVO> read(SystemDictReadDTO req);

    Page<SystemDictDetailVO> readPage(SystemDictReadDTO req);

    Boolean checkExists(SystemDictReadDTO req) throws BusinessException;

    void update(SystemDictUpdateDTO req) throws BusinessException;

    void delete(SystemDictDeleteDTO req) throws BusinessException;

}
