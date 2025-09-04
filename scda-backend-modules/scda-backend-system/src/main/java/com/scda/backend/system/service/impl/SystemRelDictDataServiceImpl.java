package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemRelDictDataCreateDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataReadDTO;
import com.scda.backend.api.system.dto.SystemRelDictDataUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelDictDataDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRelDictData;
import com.scda.backend.api.system.ISystemRelDictDataService;
import com.scda.backend.system.mapper.SystemRelDictDataMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_dict_data(系统字典与字典数据关联)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRelDictDataServiceImpl extends ServiceImpl<SystemRelDictDataMapper, SystemRelDictData>
    implements ISystemRelDictDataService{

    @Override
    public void create(SystemRelDictDataCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemRelDictDataDetailVO> read(SystemRelDictDataReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemRelDictDataDetailVO> readPage(SystemRelDictDataReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemRelDictDataReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemRelDictDataUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemRelDictDataDeleteDTO req) throws BusinessException {

    }
}




