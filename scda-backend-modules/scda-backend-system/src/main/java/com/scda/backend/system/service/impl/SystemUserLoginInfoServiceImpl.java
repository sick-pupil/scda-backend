package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemUserLoginInfoCreateDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoDeleteDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoReadDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoUpdateDTO;
import com.scda.backend.api.system.vo.SystemApiOperLogDetailVO;
import com.scda.backend.api.system.vo.SystemUserLoginInfoDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemUserLoginInfo;
import com.scda.backend.api.system.ISystemUserLoginInfoService;
import com.scda.backend.system.mapper.SystemUserLoginInfoMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 10045
* @description 针对表【system_user_login_info(系统用户登录日志)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemUserLoginInfoServiceImpl extends ServiceImpl<SystemUserLoginInfoMapper, SystemUserLoginInfo>
    implements ISystemUserLoginInfoService{

    @Override
    public void create(SystemUserLoginInfoCreateDTO req) throws BusinessException {
        SystemUserLoginInfo obj = new SystemUserLoginInfo();
        BeanUtils.copyProperties(req, obj);
        save(obj);
    }

    @Override
    public List<SystemUserLoginInfoDetailVO> read(SystemUserLoginInfoReadDTO req) {
        LambdaQueryWrapper<SystemUserLoginInfo> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(ObjectUtils.isNotEmpty(req.getUserId()), SystemUserLoginInfo::getUserId, req.getUserId());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getIp()), SystemUserLoginInfo::getIp, req.getIp());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getLocation()), SystemUserLoginInfo::getLocation, req.getLocation());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getCountry()), SystemUserLoginInfo::getCountry, req.getCountry());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getProvince()), SystemUserLoginInfo::getProvince, req.getProvince());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getCity()), SystemUserLoginInfo::getCity, req.getCity());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getDistrict()), SystemUserLoginInfo::getDistrict, req.getDistrict());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getTown()), SystemUserLoginInfo::getTown, req.getTown());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getUa()), SystemUserLoginInfo::getUa, req.getUa());

        return CollectionUtils.emptyIfNull(list(lambdaQueryWrapper)).stream().map(i -> {
            SystemUserLoginInfoDetailVO obj = new SystemUserLoginInfoDetailVO();
            BeanUtils.copyProperties(i, obj);
            return obj;
        }).collect(Collectors.toList());
    }

    @Override
    public Page<SystemUserLoginInfoDetailVO> readPage(SystemUserLoginInfoReadDTO req) {
        Page<SystemUserLoginInfo> page = new Page<>(req.getPageQuery().getCurrentPageIndex(), req.getPageQuery().getPageSize());

        LambdaQueryWrapper<SystemUserLoginInfo> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(ObjectUtils.isNotEmpty(req.getUserId()), SystemUserLoginInfo::getUserId, req.getUserId());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getIp()), SystemUserLoginInfo::getIp, req.getIp());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getLocation()), SystemUserLoginInfo::getLocation, req.getLocation());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getCountry()), SystemUserLoginInfo::getCountry, req.getCountry());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getProvince()), SystemUserLoginInfo::getProvince, req.getProvince());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getCity()), SystemUserLoginInfo::getCity, req.getCity());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getDistrict()), SystemUserLoginInfo::getDistrict, req.getDistrict());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getTown()), SystemUserLoginInfo::getTown, req.getTown());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getUa()), SystemUserLoginInfo::getUa, req.getUa());

        page(page, lambdaQueryWrapper);

        List<SystemUserLoginInfoDetailVO> pageList = (List<SystemUserLoginInfoDetailVO>) CollectionUtils.emptyIfNull(page.getRecords().stream().map(i -> {
            SystemUserLoginInfoDetailVO detailVO = new SystemUserLoginInfoDetailVO();
            BeanUtils.copyProperties(i, detailVO);
            return detailVO;
        }).collect(Collectors.toList()));

        Page<SystemUserLoginInfoDetailVO> result = new Page<>(page.getCurrent(), page.getSize());
        result.setTotal(page.getTotal());
        result.setRecords(pageList);
        return result;
    }

    @Override
    public void update(SystemUserLoginInfoUpdateDTO req) throws BusinessException {
        SystemUserLoginInfo obj = new SystemUserLoginInfo();
        BeanUtils.copyProperties(req, obj);
        updateById(obj);
    }

    @Override
    public void delete(SystemUserLoginInfoDeleteDTO req) throws BusinessException {
        removeById(req.getId());
    }
}




