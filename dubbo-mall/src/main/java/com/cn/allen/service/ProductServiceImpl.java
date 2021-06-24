package com.cn.allen.service;

import com.cn.allen.dao.ProductDao;
import com.cn.allen.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<String,ProductEntity> productMap = new HashMap<>();
    static {
        ProductEntity product = new ProductEntity();
        product.setId("P001");
        product.setName("iponex");
        product.setPrice(10000);
        productMap.put(product.getId(),product);

        product = new ProductEntity();
        product.setId("P002");
        product.setName("大疆无人机");
        product.setPrice(100000);
        productMap.put(product.getId(),product);
    }

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductEntity getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+ System.currentTimeMillis());
        ProductEntity product = productMap.get(id);
        if (null != product){
            return product;
        }
        return productDao.getDetail(id);
    }

    @Override
    public ProductEntity modify(ProductEntity product) {
        return productDao.modify(product);
    }

    @Override
    public boolean status(String id, boolean upDown) {
        return productDao.status(id,upDown);
    }
}
