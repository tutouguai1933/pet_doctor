package com.example.petdoctor.controller;

import com.example.petdoctor.pojo.Pet;
import com.example.petdoctor.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 宠物档案表，存储宠物的详细信息，包括品种、性别、体重等 前端控制器
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private IPetService petService;

    // 创建宠物档案
    @PostMapping("/create")
    public Pet createPet(@RequestBody Pet pet) {
        return petService.createPet(pet);
    }

    // 更新宠物档案
    @PutMapping("/update")
    public Pet updatePet(@RequestBody Pet pet) {
        return petService.updatePet(pet);
    }

    // 获取用户的所有宠物档案
    @GetMapping("/user/{userId}")
    public List<Pet> getPetsByUserId(@PathVariable Long userId) {
        return petService.getPetsByUserId(userId);
    }

    // 删除宠物档案
    @DeleteMapping("/delete/{petId}")
    public String deletePet(@PathVariable Long petId) {
        boolean success = petService.deletePet(petId);
        if (success) {
            return "宠物档案删除成功";
        } else {
            throw new RuntimeException("删除失败，宠物ID不存在");
        }
    }

    // 获取单个宠物档案
    @GetMapping("/{petId}")
    public Pet getPetById(@PathVariable Long petId) {
        Pet pet = petService.getById(petId);
        if (pet == null) {
            throw new RuntimeException("宠物档案未找到");
        }
        return pet;
    }
}
