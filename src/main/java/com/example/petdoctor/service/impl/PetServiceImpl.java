package com.example.petdoctor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petdoctor.pojo.Pet;
import com.example.petdoctor.mapper.PetMapper;
import com.example.petdoctor.service.IPetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 宠物档案表，存储宠物的详细信息，包括品种、性别、体重等 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements IPetService {

    @Override
    public List<Pet> getPetsByUserId(Long userId) {
        // 根据用户ID查询宠物档案
        return this.list(new QueryWrapper<Pet>().eq("user_id", userId));
    }

    @Override
    public Pet createPet(Pet pet) {
        // 创建并保存宠物档案
        this.save(pet);
        return pet;
    }

    @Override
    public Pet updatePet(Pet pet) {
        // 更新宠物档案
        this.updateById(pet);
        return pet;
    }

    @Override
    public boolean deletePet(Long petId) {
        // 删除宠物档案
        return this.removeById(petId);
    }
}
