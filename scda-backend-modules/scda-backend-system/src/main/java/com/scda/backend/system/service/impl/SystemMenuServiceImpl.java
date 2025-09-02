package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemMenuCreateDTO;
import com.scda.backend.api.system.dto.SystemMenuDeleteDTO;
import com.scda.backend.api.system.dto.SystemMenuReadDTO;
import com.scda.backend.api.system.dto.SystemMenuUpdateDTO;
import com.scda.backend.api.system.vo.SystemMenuDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemMenu;
import com.scda.backend.api.system.ISystemMenuService;
import com.scda.backend.system.mapper.SystemMenuMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_menu(系统菜单)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu>
    implements ISystemMenuService{

    @Override
    public void create(SystemMenuCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemMenuDetailVO> read(SystemMenuReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemMenuDetailVO> readPage(SystemMenuReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemMenuReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemMenuUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemMenuDeleteDTO req) throws BusinessException {

    }
}




