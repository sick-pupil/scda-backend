package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemDictDataCreateDTO;
import com.scda.backend.api.system.dto.SystemDictDataDeleteDTO;
import com.scda.backend.api.system.dto.SystemDictDataReadDTO;
import com.scda.backend.api.system.dto.SystemDictDataUpdateDTO;
import com.scda.backend.api.system.vo.SystemDictDataDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemDictData;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_dict_data(系统字典数据)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemDictDataService extends IService<SystemDictData> {

    void create(SystemDictDataCreateDTO req) throws BusinessException;

    List<SystemDictDataDetailVO> read(SystemDictDataReadDTO req);

    Page<SystemDictDataDetailVO> readPage(SystemDictDataReadDTO req);

    Boolean checkExists(SystemDictDataReadDTO req) throws BusinessException;

    void update(SystemDictDataUpdateDTO req) throws BusinessException;

    void delete(SystemDictDataDeleteDTO req) throws BusinessException;

}
