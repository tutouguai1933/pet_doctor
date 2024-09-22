package com.example.petdoctor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petdoctor.pojo.Product;
import com.example.petdoctor.mapper.ProductMapper;
import com.example.petdoctor.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表，存储平台出售的宠物商品信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public Product findByName(String name) {
        // 根据药品名称查询药品
        return this.getOne(new QueryWrapper<Product>().eq("name", name));
    }
}
