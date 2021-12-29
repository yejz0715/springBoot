package com.ezen.spn01.dao;

import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.spn01.dto.QnaVO;

@Mapper
public interface IQnaDao {

	ArrayList<QnaVO> listQna(String id);

	void insertQna(@Valid QnaVO qnavo);

}
