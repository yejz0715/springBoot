package com.ezen.spn01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spn01.dao.IOrderDao;
import com.ezen.spn01.dto.CartVO;
import com.ezen.spn01.dto.OrderVO;

@Service
public class OrderServie {

	@Autowired
	IOrderDao odao;

	public int insertOrder(List<CartVO> cartList, String id) {
		int oseq=0;
		//Orders테이블에 현재 아이디로 레코드를 추가
		odao.insertOrders(id);
		//방금 추가된 Orders테이블
		oseq=odao.LookupMaxOseq();
		
		for(CartVO cvo : cartList ) {
			odao.insertOrderDetail(cvo, oseq);
			odao.deleteCart(cvo.getCseq());
		}
		
		return oseq;
	}

	public ArrayList<OrderVO> listOrderByOseq(int oseq) {
		
		return odao.listOrderByOseq(oseq);
	}

	public ArrayList<Integer> selectOseqOrderIng(String id) {
		
		return odao.selectOseqOrderIng(id);
	}

	public ArrayList<Integer> oseqListAll(String id) {
		
		return odao.oseqListAll(id);
	}
}
