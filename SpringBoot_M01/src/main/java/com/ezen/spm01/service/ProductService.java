package com.ezen.spm01.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spm01.dao.IProductDao;
import com.ezen.spm01.dto.ProductVO;

@Service
public class ProductService {
	
	@Autowired
	IProductDao pdao;

	public ArrayList<ProductVO> getNewList() {
		return pdao.getNewList();
	}

	public ArrayList<ProductVO> getBestList() {
		return pdao.getBestList();
	}
	
}
