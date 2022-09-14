package com.zhuicat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuicat.domain.ResponseResult;
import com.zhuicat.domain.entity.Article;

/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2022-09-13 22:47:20
 */
public interface ArticleService extends IService<Article> {

    // 查询热门文章
    ResponseResult hotArticleList();
}
