package com.cn.allen.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cn.allen.entity.OrderEntity;
import com.cn.allen.entity.ProductEntity;
import com.cn.allen.service.OrderService;
import com.cn.allen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/24
 * @Description:
 */
@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        ProductEntity productEntity = productService.getDetail("1");
        OrderEntity orderView = orderService.getDetail(id);

        request.setAttribute("productView", productEntity);
        request.setAttribute("orderView", orderView);
        return "index";
    }

}

