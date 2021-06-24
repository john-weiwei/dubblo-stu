package com.cn.allen.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<ProductEntity> productEntityList = new ArrayList<>();
    public void addProduct(ProductEntity productEntity){
        productEntityList.add(productEntity);
    }
}
