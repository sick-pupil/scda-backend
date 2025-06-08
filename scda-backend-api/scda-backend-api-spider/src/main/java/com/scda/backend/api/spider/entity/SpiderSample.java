package com.scda.backend.api.spider.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;


@ApiModel(value="SpiderSample对象", description="抓取样本")
@Data
@TableName("spider_sample")
/**
* 抓取样本
* @TableName spider_sample
*/
public class SpiderSample extends Model<SpiderSample> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 样本类名
    */
    @ApiModelProperty("样本类名")
    @TableField("class_name")
    private String className;

    /**
    * 样本名称
    */
    @ApiModelProperty("样本名称")
    @TableField("name")
    private String name;

    /**
    * 描述
    */
    @ApiModelProperty("描述")
    @TableField("desc")
    private String desc;

    /**
    * 样本文件md5
    */
    @ApiModelProperty("样本文件md5")
    @TableField("md5")
    private String md5;

    /**
    * 初始化逻辑
    */
    @ApiModelProperty("初始化逻辑")
    @TableField("init_logic")
    private String initLogic;

    /**
    * 运行逻辑
    */
    @ApiModelProperty("运行逻辑")
    @TableField("run_logic")
    private String runLogic;

    /**
    * 销毁逻辑
    */
    @ApiModelProperty("销毁逻辑")
    @TableField("destroy_logic")
    private String destroyLogic;

    /**
    * 是否生效
    */
    @ApiModelProperty("是否生效")
    @TableField("effect_status")
    private Integer effectStatus;

    /**
    * 是否被删除
    */
    @ApiModelProperty("是否被删除")
    @TableLogic
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;

    /**
    * 创建者
    */
    @ApiModelProperty("创建者")
    @TableField(value = "creator_user_id", fill = FieldFill.INSERT)
    private Long creatorUserId;

    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
    * 更新者
    */
    @ApiModelProperty("更新者")
    @TableField(value = "updator_user_id", fill = FieldFill.INSERT_UPDATE)
    private Long updatorUserId;

    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
    * 版本号
    */
    @ApiModelProperty("版本号")
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;

    /**
    * 租户id
    */
    @ApiModelProperty("租户id")
    @TableField(value = "tenant_id", fill = FieldFill.INSERT)
    private Long tenantId;


}
