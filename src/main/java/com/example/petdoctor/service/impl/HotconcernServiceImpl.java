package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.Hotconcern;
import com.example.petdoctor.mapper.HotconcernMapper;
import com.example.petdoctor.service.IHotconcernService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 热门关注表，存储用户热门查询的症状及分类信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class HotconcernServiceImpl extends ServiceImpl<HotconcernMapper, Hotconcern> implements IHotconcernService {

}
