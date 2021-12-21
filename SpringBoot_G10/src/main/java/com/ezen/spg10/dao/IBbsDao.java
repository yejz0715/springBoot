package com.ezen.spg10.dao;

import java.util.List;

import com.ezen.spg10.BbsDto;

public interface IBbsDao {
	
public List<BbsDto> list(); //리스트리턴
public int write(BbsDto bdto); //게시물쓰기
public int update(BbsDto bdto); //수정
public int delete(String bdto); //삭제
public BbsDto view(String id); //게시물하나보기
}
