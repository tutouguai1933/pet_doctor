package com.example.petdoctor.service;

import com.example.petdoctor.pojo.Pet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物档案表，存储宠物的详细信息，包括品种、性别、体重等 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IPetService extends IService<Pet> {
    // 根据用户ID获取该用户的所有宠物档案
    List<Pet> getPetsByUserId(Long userId);

    // 创建宠物档案
    Pet createPet(Pet pet);

    // 更新宠物档案
    Pet updatePet(Pet pet);

    // 删除宠物档案
    boolean deletePet(Long petId);
}
