package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemDictDataCreateDTO;
import com.scda.backend.api.system.dto.SystemDictDataDeleteDTO;
import com.scda.backend.api.system.dto.SystemDictDataReadDTO;
import com.scda.backend.api.system.dto.SystemDictDataUpdateDTO;
import com.scda.backend.api.system.vo.SystemDictDataDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemDictData;
import com.scda.backend.api.system.ISystemDictDataService;
import com.scda.backend.system.mapper.SystemDictDataMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_dict_data(系统字典数据)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemDictDataServiceImpl extends ServiceImpl<SystemDictDataMapper, SystemDictData>
    implements ISystemDictDataService{

    @Override
    public void create(SystemDictDataCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemDictDataDetailVO> read(SystemDictDataReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemDictDataDetailVO> readPage(SystemDictDataReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemDictDataReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemDictDataUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemDictDataDeleteDTO req) throws BusinessException {

    }
}




