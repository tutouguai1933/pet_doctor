package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表，存储宠物医生平台的用户信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "User对象", description = "用户表，存储宠物医生平台的用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户名，必须唯一")
    private String username;

    @ApiModelProperty("加密后的密码")
    private String password;

    @ApiModelProperty("用户的手机号")
    private String phoneNumber;

    @ApiModelProperty("用户头像的URL")
    private String avatarUrl;

    @ApiModelProperty("用户注册时间")
    private LocalDateTime registrationDate;
}
