package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemRelDictDataCreateDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataReadDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelDictDataDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemRelDictData;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_dict_data(系统字典与字典数据关联)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemRelDictDataService extends IService<SystemRelDictData> {

    void create(SystemRelDictDataCreateDTO req) throws BusinessException;

    List<SystemRelDictDataDetailVO> read(SystemRelDictDataReadDTO req);

    Page<SystemRelDictDataDetailVO> readPage(SystemRelDictDataReadDTO req);

    Boolean checkExists(SystemRelDictDataReadDTO req) throws BusinessException;

    void update(SystemRelDictDataUpdateDTO req) throws BusinessException;

    void delete(SystemRelDictDataDeleteDTO req) throws BusinessException;
}
