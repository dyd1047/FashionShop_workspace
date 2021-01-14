package com.koreait.fashionshop.model.product.service;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.excel.ProductConverter;

@Service
public class DumpServiceImpl implements DumpService{
	private static final Logger logger = LoggerFactory.getLogger(DumpService.class);
	
	@Autowired
	private ProductConverter productConverter;
	
	@Override
	public void regist(String path) {
		//엑셀로 읽어서 데이터로 넣기
		List<Product> productList = productConverter.convertFromFile(path);
		logger.debug("");
	}

}
