package com.cn.allen.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/24
 * @Description:
 */
@Data
public class ProductEntity implements Serializable {
    private String id;
    private long price;
    private String name;
    private int status;//上下架
}
