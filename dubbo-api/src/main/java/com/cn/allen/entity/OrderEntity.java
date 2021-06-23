package com.cn.allen.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/23
 * @Description:
 */
@Data
public class OrderEntity implements Serializable {
    private String id;
    private long money;
    private String userId;
    private int status = 0;
}
