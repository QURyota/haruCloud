package com.ryota.cofuser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author ryota
 * @since 2022-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CofUser对象", description="用户")
public class CofUser implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "员工ID")
    @TableField("EMP_ID")
    private String empId;

    @ApiModelProperty(value = "用户名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private Date updateTime;

    @ApiModelProperty(value = "用户邮箱")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "租户ID")
    @TableField("TENANT_ID")
    private String tenantId;

    @ApiModelProperty(value = "用户密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "TOKEN加密密钥")
    @TableField("SALT")
    private String salt;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "认证模式")
    @TableField("AUTH_MODE")
    private String authMode;

    @ApiModelProperty(value = "解锁时间")
    @TableField("UNLOCK_TIME")
    private Date unlockTime;

    @ApiModelProperty(value = "最后登陆时间")
    @TableField("LAST_LOGIN")
    private Date lastLogin;

    @ApiModelProperty(value = "有效开始日期")
    @TableField("START_DATE")
    private Date startDate;

    @ApiModelProperty(value = "有效结束日期")
    @TableField("END_DATE")
    private Date endDate;

    @ApiModelProperty(value = "是否固定，如果是，则数据不能修改，不能删除")
    @TableField("IS_FIXED")
    private Boolean isFixed;

    @ApiModelProperty(value = "是否AD账号")
    @TableField("IS_ADUSER")
    private String isAduser;

    @ApiModelProperty(value = "手机")
    @TableField("PHONE")
    private String phone;

    @ApiModelProperty(value = "数据来源")
    @TableField("DATA_SOURCE")
    private String dataSource;


}
