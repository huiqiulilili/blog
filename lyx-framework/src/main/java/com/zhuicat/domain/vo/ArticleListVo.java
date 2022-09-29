package com.zhuicat.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhuicat
 * @since 2022/9/29 14:52
 */
@Data
public class ArticleListVo {

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
     * 所属分类名字
     */
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
