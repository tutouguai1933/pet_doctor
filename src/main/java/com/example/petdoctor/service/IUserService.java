package com.example.petdoctor.service;

import com.example.petdoctor.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表，存储宠物医生平台的用户信息 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IUserService extends IService<User> {
    User login(String username, String password);
}
