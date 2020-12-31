package com.koreait.fashionshop.model.product.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Product;

public interface ProductService {
	public List selectAll(); //모든 레코드 가져오기
	public List selectAllById(int subcategory_id); //선택한 상위 카테고리에 소속된 하위카테고리 가져오기
	public Product select(int product_id);
	public void regist(Product product); //insert만 하는게 아니기 때문..
	public void update(Product product);
	public void delete(int product_id);
}
