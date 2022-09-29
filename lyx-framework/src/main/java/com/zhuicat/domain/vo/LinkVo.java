package com.zhuicat.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhuicat
 * @since 2022/9/29 16:03
 */
@Data
public class LinkVo {
    private Long id;
    private String name;
    private String logo;
    private String description;
    //网站地址
    private String address;

}
