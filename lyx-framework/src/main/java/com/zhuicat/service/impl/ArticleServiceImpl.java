package com.zhuicat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuicat.constants.SystemConstants;
import com.zhuicat.domain.ResponseResult;
import com.zhuicat.domain.entity.Article;
import com.zhuicat.domain.vo.HotArticleVo;
import com.zhuicat.mapper.ArticleMapper;
import com.zhuicat.service.ArticleService;
import com.zhuicat.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2022-09-13 22:47:24
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {

    // 查询热门文章
    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL) // 必须是正式文章
                .orderByDesc(Article::getViewCount); // 按照浏览量降序排序
        // 最多查询十条
        Page<Article> page = new Page<>(1,10);
        page(page,lambdaQueryWrapper);
        List<Article> articles = page.getRecords();
        // bean 拷贝
        List<HotArticleVo> hotArticleVos = new ArrayList<>();
        BeanCopyUtils.copyList(articles,HotArticleVo.class);
        return ResponseResult.okResult(hotArticleVos);
    }
}
