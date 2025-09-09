package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemApiOperLogCreateDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogDeleteDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogReadDTO;
import com.scda.backend.api.system.dto.SystemApiOperLogUpdateDTO;
import com.scda.backend.api.system.vo.SystemApiOperLogDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemApiOperLog;
import com.scda.backend.api.system.ISystemApiOperLogService;
import com.scda.backend.system.mapper.SystemApiOperLogMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 10045
* @description 针对表【system_api_oper_log(系统接口操作日志)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemApiOperLogServiceImpl extends ServiceImpl<SystemApiOperLogMapper, SystemApiOperLog>
    implements ISystemApiOperLogService{

    @Override
    public void create(SystemApiOperLogCreateDTO req) throws BusinessException {
        SystemApiOperLog obj = new SystemApiOperLog();
        BeanUtils.copyProperties(req, obj);
        save(obj);
    }

    @Override
    public List<SystemApiOperLogDetailVO> read(SystemApiOperLogReadDTO req) {
        LambdaQueryWrapper<SystemApiOperLog> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqUrl()), SystemApiOperLog::getReqUrl, req.getReqUrl());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqMethod()), SystemApiOperLog::getReqMethod, req.getReqMethod());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqIp()), SystemApiOperLog::getReqIp, req.getReqIp());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqLocation()), SystemApiOperLog::getReqLocation, req.getReqLocation());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqCountry()), SystemApiOperLog::getReqCountry, req.getReqCountry());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqProvince()), SystemApiOperLog::getReqProvince, req.getReqProvince());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqCity()), SystemApiOperLog::getReqCity, req.getReqCity());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqDistrict()), SystemApiOperLog::getReqDistrict, req.getReqDistrict());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqTown()), SystemApiOperLog::getReqTown, req.getReqTown());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqParams()), SystemApiOperLog::getReqParams, req.getReqParams());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getRespParams()), SystemApiOperLog::getRespParams, req.getRespParams());
        lambdaQueryWrapper.eq(ObjectUtils.isNotEmpty(req.getRespType()), SystemApiOperLog::getRespType, req.getRespType());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getExceptionMsg()), SystemApiOperLog::getExceptionMsg, req.getExceptionMsg());
        lambdaQueryWrapper.lt(ObjectUtils.isNotEmpty(req.getMaxCostTime()), SystemApiOperLog::getCostTime, req.getMaxCostTime());
        lambdaQueryWrapper.gt(ObjectUtils.isNotEmpty(req.getMinCostTime()), SystemApiOperLog::getCostTime, req.getMinCostTime());

        return CollectionUtils.emptyIfNull(list(lambdaQueryWrapper)).stream().map(i -> {
            SystemApiOperLogDetailVO detailVO = new SystemApiOperLogDetailVO();
            BeanUtils.copyProperties(i, detailVO);
            return detailVO;
        }).collect(Collectors.toList());
    }

    @Override
    public Page<SystemApiOperLogDetailVO> readPage(SystemApiOperLogReadDTO req) {
        Page<SystemApiOperLog> page = new Page<>(req.getPageQuery().getCurrentPageIndex(), req.getPageQuery().getPageSize());

        LambdaQueryWrapper<SystemApiOperLog> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqUrl()), SystemApiOperLog::getReqUrl, req.getReqUrl());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqMethod()), SystemApiOperLog::getReqMethod, req.getReqMethod());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqIp()), SystemApiOperLog::getReqIp, req.getReqIp());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqLocation()), SystemApiOperLog::getReqLocation, req.getReqLocation());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqCountry()), SystemApiOperLog::getReqCountry, req.getReqCountry());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqProvince()), SystemApiOperLog::getReqProvince, req.getReqProvince());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqCity()), SystemApiOperLog::getReqCity, req.getReqCity());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqDistrict()), SystemApiOperLog::getReqDistrict, req.getReqDistrict());
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(req.getReqTown()), SystemApiOperLog::getReqTown, req.getReqTown());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getReqParams()), SystemApiOperLog::getReqParams, req.getReqParams());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getRespParams()), SystemApiOperLog::getRespParams, req.getRespParams());
        lambdaQueryWrapper.eq(ObjectUtils.isNotEmpty(req.getRespType()), SystemApiOperLog::getRespType, req.getRespType());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getExceptionMsg()), SystemApiOperLog::getExceptionMsg, req.getExceptionMsg());
        lambdaQueryWrapper.lt(ObjectUtils.isNotEmpty(req.getMaxCostTime()), SystemApiOperLog::getCostTime, req.getMaxCostTime());
        lambdaQueryWrapper.gt(ObjectUtils.isNotEmpty(req.getMinCostTime()), SystemApiOperLog::getCostTime, req.getMinCostTime());

        page(page, lambdaQueryWrapper);

        List<SystemApiOperLogDetailVO> pageList = (List<SystemApiOperLogDetailVO>) CollectionUtils.emptyIfNull(page.getRecords().stream().map(i -> {
            SystemApiOperLogDetailVO detailVO = new SystemApiOperLogDetailVO();
            BeanUtils.copyProperties(i, detailVO);
            return detailVO;
        }).collect(Collectors.toList()));

        Page<SystemApiOperLogDetailVO> result = new Page<>(page.getCurrent(), page.getSize());
        result.setTotal(page.getTotal());
        result.setRecords(pageList);
        return result;
    }

    @Override
    public void update(SystemApiOperLogUpdateDTO req) throws BusinessException {
        SystemApiOperLog obj = new SystemApiOperLog();
        BeanUtils.copyProperties(req, obj);
        updateById(obj);
    }

    @Override
    public void delete(SystemApiOperLogDeleteDTO req) throws BusinessException {
        removeById(req.getId());
    }
}




