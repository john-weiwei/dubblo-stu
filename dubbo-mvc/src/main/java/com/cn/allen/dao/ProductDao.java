package com.cn.allen.dao;

import com.cn.allen.entity.ProductEntity;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/24
 * @Description:
 */
public interface ProductDao {
    ProductEntity getDetail(String id);
    ProductEntity modify(ProductEntity product);
    boolean status(String id, boolean upDown);
}
