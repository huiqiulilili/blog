package com.zhuicat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuicat.constants.SystemConstants;
import com.zhuicat.domain.ResponseResult;
import com.zhuicat.domain.entity.Link;
import com.zhuicat.domain.vo.LinkVo;
import com.zhuicat.mapper.LinkMapper;
import com.zhuicat.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import com.zhuicat.service.LinkService;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-09-29 15:58:33
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        // 查询所有审核通过的
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.Link_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);

        // 转换为Vo
        List<LinkVo> linkVos =  BeanCopyUtils.copyList(links, LinkVo.class);
        // 封装返回
        return ResponseResult.okResult(linkVos);
    }
}

