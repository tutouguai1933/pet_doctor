package com.example.petdoctor.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petdoctor.pojo.User;
import com.example.petdoctor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    // 注册用户
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        try {
            userService.save(user); // 使用 MyBatis-Plus 提供的 save 方法
            return user;
        } catch (RuntimeException e) {
            throw new RuntimeException("注册失败: " + e.getMessage());
        }
    }

    // 用户登录
    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        try {
            return userService.login(username, password); // 调用自定义的 login 方法
        } catch (RuntimeException e) {
            throw new RuntimeException("登录失败: " + e.getMessage());
        }
    }

    // 根据用户名查询用户信息
    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            throw new RuntimeException("用户未找到");
        }
        return user;
    }
}
