package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.PromotionProduct;
import com.example.petdoctor.mapper.PromotionProductMapper;
import com.example.petdoctor.service.IPromotionProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 促销活动与商品的关联表，记录促销活动涉及的商品 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class PromotionProductServiceImpl extends ServiceImpl<PromotionProductMapper, PromotionProduct> implements IPromotionProductService {

}
