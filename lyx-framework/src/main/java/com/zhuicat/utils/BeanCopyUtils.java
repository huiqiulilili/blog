package com.zhuicat.utils;


import com.zhuicat.domain.entity.Article;
import com.zhuicat.domain.vo.HotArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * bean拷贝
 */
public class BeanCopyUtils {
    private void BeanCopyUtils() {

    }

    /**
     * 拷贝对象
     * @return
     */
    public static <V> V copyBean(Object source,Class<V> clazz) {
        // 创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            // 实现属性拷贝
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回结果
        return result;
    }

    public static <O,V>List<V> copyList(List<O> list,Class<V> clazz){
        List<V> result = new ArrayList<>();
        for (O o : list) {
            V v = copyBean(o, clazz);
            result.add(v);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Article article = new Article();
            article.setId(1L);
            article.setTitle("zzz"+i);
            articles.add(article);
        }

        List<HotArticleVo> hotArticleVos = copyList(articles, HotArticleVo.class);
        System.out.println(hotArticleVos);
    }

}
