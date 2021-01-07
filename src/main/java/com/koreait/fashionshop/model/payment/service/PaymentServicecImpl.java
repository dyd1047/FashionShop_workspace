package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.payment.repository.CartDAO;

@Service
public class PaymentServicecImpl implements PaymentService{
	@Autowired
	private CartDAO cartDAO;

	@Override
	public List selectCartList() {
		return null;
	}

	@Override
	public List selectCartList(int member_id) {
		return cartDAO.selectAll(member_id);
	}

	@Override
	public Cart selectCart(int cart_id) {
		return null;
	}

	@Override
	public void insert(Cart cart) throws CartException{
		cartDAO.duplicateCheck(cart);
		cartDAO.insert(cart);
	}

	@Override
	public void update(List<Cart> cartList) throws CartException{
		//상품 갯수만큼 수정 요청
		for(Cart cart : cartList) {
			cartDAO.update(cart);
		}
	}

	@Override
	public void delete(Cart cart) {
		
	}

	@Override
	public void delete(Member member) throws CartException{
		cartDAO.delete(member);
	}

}
