package com.cn.allen.dao;

import com.cn.allen.entity.ProductEntity;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/24
 * @Description:
 */
@Service
public class ProductDaoImpl implements ProductDao {
    @Override
    public ProductEntity getDetail(String id) {
        ProductEntity product = new ProductEntity();
        product.setId("P003");
        product.setName("华为meta10");
        product.setPrice(5000);
        return product;
    }

    @Override
    public ProductEntity modify(ProductEntity product) {
        product = new ProductEntity();
        product.setId("P004");
        product.setName("小米机器人");
        product.setPrice(2000);
        return product;
    }

    @Override
    public boolean status(String id, boolean upDown) {
        System.out.println("商品上下架成功");
        return true;
    }
}
