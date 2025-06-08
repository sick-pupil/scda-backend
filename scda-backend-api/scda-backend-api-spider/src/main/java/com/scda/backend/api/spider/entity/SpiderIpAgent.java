package com.scda.backend.api.spider.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;


@ApiModel(value="SpiderIpAgent对象", description="ip代理池")
@Data
@TableName("spider_ip_agent")
/**
* ip代理池
* @TableName spider_ip_agent
*/
public class SpiderIpAgent extends Model<SpiderIpAgent> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 服务商
    */
    @ApiModelProperty("服务商")
    @TableField("vendor")
    private String vendor;

    /**
    * 获取代理ip池的请求地址
    */
    @ApiModelProperty("获取代理ip池的请求地址")
    @TableField("access_ip_agent_url")
    private String accessIpAgentUrl;

    /**
    * 获取代理ip的用户名
    */
    @ApiModelProperty("获取代理ip的用户名")
    @TableField("username")
    private String username;

    /**
    * 获取代理ip的密码
    */
    @ApiModelProperty("获取代理ip的密码")
    @TableField("password")
    private String password;

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
