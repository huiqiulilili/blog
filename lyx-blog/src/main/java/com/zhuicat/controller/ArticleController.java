package com.zhuicat.controller;

import com.zhuicat.domain.ResponseResult;
import com.zhuicat.domain.entity.Article;
import com.zhuicat.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章表(Article)表控制层
 *
 * @author makejava
 * @since 2022-09-13 22:47:08
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        // 查询热门文章
        return articleService.hotArticleList();
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(@RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize,
                                      @RequestParam Long categoryId) {
        return articleService.articleList(pageNum,pageSize,categoryId);
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }
}

