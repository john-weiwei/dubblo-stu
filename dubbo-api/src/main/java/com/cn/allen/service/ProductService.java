package com.cn.allen.service;

import com.cn.allen.entity.ProductEntity;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/24
 * @Description:
 */
public interface ProductService {
    ProductEntity getDetail(String id);
    ProductEntity modify(ProductEntity productEntity);
    boolean status(String id, boolean upDown);
}
