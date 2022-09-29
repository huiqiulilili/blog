package com.zhuicat.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhuicat
 * @since 2022/9/29 15:48
 */
@Data
public class ArticleDetailVo {
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章摘要
     */
    private String summary;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 所属分类名字
     */
    private Long categoryId;
    private String categoryName;
    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 访问量
     */
    private Long viewCount;
    private Date createTime;

}
