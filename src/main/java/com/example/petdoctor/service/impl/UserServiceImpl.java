package com.example.petdoctor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petdoctor.pojo.User;
import com.example.petdoctor.mapper.UserMapper;
import com.example.petdoctor.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表，存储宠物医生平台的用户信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User login(String username, String password) {
        // 使用 MyBatis-Plus 提供的 QueryWrapper 来查询用户
        User user = this.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("用户名或密码错误");
        }
        return user;
    }
}
