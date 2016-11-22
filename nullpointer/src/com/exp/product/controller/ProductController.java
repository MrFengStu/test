package com.exp.product.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.exp.entity.TbGoods;
import com.exp.product.service.ProductServiceImpl;
import com.framework.EncodingTool;

@Controller
@RequestMapping("product")
public class ProductController {
	@Resource
	private ProductServiceImpl productServiceImpl;

	@RequestMapping("aaa")
	public void searchAll() {
		productServiceImpl.searchAll();
		System.out.println("aaa");
	}	
}
