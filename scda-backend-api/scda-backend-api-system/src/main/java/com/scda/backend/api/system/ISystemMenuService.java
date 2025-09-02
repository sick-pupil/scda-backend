package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemMenuCreateDTO;
import com.scda.backend.api.system.dto.SystemMenuDeleteDTO;
import com.scda.backend.api.system.dto.SystemMenuReadDTO;
import com.scda.backend.api.system.dto.SystemMenuUpdateDTO;
import com.scda.backend.api.system.vo.SystemMenuDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemMenu;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_menu(系统菜单)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemMenuService extends IService<SystemMenu> {

    void create(SystemMenuCreateDTO req) throws BusinessException;

    List<SystemMenuDetailVO> read(SystemMenuReadDTO req);

    Page<SystemMenuDetailVO> readPage(SystemMenuReadDTO req);

    Boolean checkExists(SystemMenuReadDTO req) throws BusinessException;

    void update(SystemMenuUpdateDTO req) throws BusinessException;

    void delete(SystemMenuDeleteDTO req) throws BusinessException;
}
