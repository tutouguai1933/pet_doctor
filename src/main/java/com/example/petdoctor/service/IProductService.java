package com.example.petdoctor.service;

import com.example.petdoctor.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品表，存储平台出售的宠物商品信息 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IProductService extends IService<Product> {
    // 自定义的方法可以在此扩展，例如根据药品名称查询
    Product findByName(String name);
}
