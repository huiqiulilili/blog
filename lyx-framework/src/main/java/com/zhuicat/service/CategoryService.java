package com.zhuicat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuicat.domain.ResponseResult;
import com.zhuicat.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-09-15 08:36:17
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

