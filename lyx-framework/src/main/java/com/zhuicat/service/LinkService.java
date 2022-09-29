package com.zhuicat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuicat.domain.ResponseResult;
import com.zhuicat.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-09-29 15:58:32
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

