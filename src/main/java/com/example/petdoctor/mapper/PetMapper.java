package com.example.petdoctor.mapper;

import com.example.petdoctor.pojo.Pet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 宠物档案表，存储宠物的详细信息，包括品种、性别、体重等 Mapper 接口
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface PetMapper extends BaseMapper<Pet> {

}
