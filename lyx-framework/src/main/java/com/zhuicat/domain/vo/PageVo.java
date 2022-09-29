package com.zhuicat.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhuicat
 * @since 2022/9/29 14:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {

    private List rows;
    private Long total;
}
