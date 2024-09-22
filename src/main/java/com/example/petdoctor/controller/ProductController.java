package com.example.petdoctor.controller;

import com.example.petdoctor.pojo.Product;
import com.example.petdoctor.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品表，存储平台出售的宠物商品信息 前端控制器
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    // 添加药品
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    // 更新药品
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        productService.updateById(product);
        return product;
    }

    // 删除药品
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        boolean success = productService.removeById(id);
        if (success) {
            return "药品删除成功";
        } else {
            throw new RuntimeException("药品ID不存在，删除失败");
        }
    }

    // 获取所有药品
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.list();
    }

    // 根据名称获取药品
    @GetMapping("/findByName/{name}")
    public Product findByName(@PathVariable String name) {
        return productService.findByName(name);
    }
}
