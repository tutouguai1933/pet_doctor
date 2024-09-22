package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.Promotion;
import com.example.petdoctor.mapper.PromotionMapper;
import com.example.petdoctor.service.IPromotionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 促销活动表，存储平台的促销活动信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements IPromotionService {

}
