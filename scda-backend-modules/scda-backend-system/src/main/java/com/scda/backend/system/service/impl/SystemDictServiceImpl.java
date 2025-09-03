package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemDictCreateDTO;
import com.scda.backend.api.system.dto.SystemDictDeleteDTO;
import com.scda.backend.api.system.dto.SystemDictReadDTO;
import com.scda.backend.api.system.dto.SystemDictUpdateDTO;
import com.scda.backend.api.system.vo.SystemDictDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemDict;
import com.scda.backend.api.system.ISystemDictService;
import com.scda.backend.system.mapper.SystemDictMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_dict(系统字典)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemDictServiceImpl extends ServiceImpl<SystemDictMapper, SystemDict>
    implements ISystemDictService{

    @Override
    public void create(SystemDictCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemDictDetailVO> read(SystemDictReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemDictDetailVO> readPage(SystemDictReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemDictReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemDictUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemDictDeleteDTO req) throws BusinessException {

    }
}




