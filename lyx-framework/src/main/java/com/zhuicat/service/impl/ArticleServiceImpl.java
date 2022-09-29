package com.zhuicat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuicat.constants.SystemConstants;
import com.zhuicat.domain.ResponseResult;
import com.zhuicat.domain.entity.Article;
import com.zhuicat.domain.entity.Category;
import com.zhuicat.domain.vo.ArticleDetailVo;
import com.zhuicat.domain.vo.ArticleListVo;
import com.zhuicat.domain.vo.HotArticleVo;
import com.zhuicat.domain.vo.PageVo;
import com.zhuicat.mapper.ArticleMapper;
import com.zhuicat.service.ArticleService;
import com.zhuicat.service.CategoryService;
import com.zhuicat.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2022-09-13 22:47:24
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private CategoryService categoryService;

    // 查询热门文章
    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL) // 必须是正式文章
                .orderByDesc(Article::getViewCount); // 按照浏览量降序排序
        // 最多查询十条
        Page<Article> page = new Page<>(1, 10);
        page(page, lambdaQueryWrapper);
        List<Article> articles = page.getRecords();
        // bean 拷贝
        List<HotArticleVo> hotArticleVos = new ArrayList<>();
        BeanCopyUtils.copyList(articles, HotArticleVo.class);
        return ResponseResult.okResult(hotArticleVos);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        // 查询条件
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // ①如果有传递 categoryId，要求查询要和传入的相同
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        // ②状态是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // ③对isTop进行降序
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);
        // 分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, lambdaQueryWrapper);

        // 查询categoryName
        List<Article> articles = page.getRecords();
        articles.stream().map(article -> {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
            return article;
        }).collect(Collectors.toList());
        // 封装查询结果
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyList(page.getRecords(), ArticleListVo.class);

        PageVo pageVo = new PageVo(articleListVos, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        // 根据id查询文章
        Article article = this.getById(id);
        // 转换成vo
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        // 根据分类id查询分类名称
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if (category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        return ResponseResult.okResult(articleDetailVo);
    }
}
