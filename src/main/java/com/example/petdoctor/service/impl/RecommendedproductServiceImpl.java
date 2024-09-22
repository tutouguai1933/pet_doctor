package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.Recommendedproduct;
import com.example.petdoctor.mapper.RecommendedproductMapper;
import com.example.petdoctor.service.IRecommendedproductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 推荐商品表，存储系统推荐给用户的商品信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class RecommendedproductServiceImpl extends ServiceImpl<RecommendedproductMapper, Recommendedproduct> implements IRecommendedproductService {

}
