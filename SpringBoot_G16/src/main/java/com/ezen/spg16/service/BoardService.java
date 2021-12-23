package com.ezen.spg16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.ezen.spg16.dao.IBoardDao;
import com.ezen.spg16.dto.BoardVO;
import com.ezen.spg16.dto.Paging;

@Service
public class BoardService {

	@Autowired
	IBoardDao bdao;
	
	@Autowired
	TransactionTemplate tt;

	public List<BoardVO> selectBoardAll(Paging paging) {
		// 10 개의 게시물 리스트가 리턴되어 list 에 저정됩니다
		List<BoardVO> list =  bdao.selectBoardAll( paging );
		for( BoardVO bvo : list) {
			// 각 게시물번호를 이용하여  댓글 갯수를 조회하는 메서드를 호출하여 갯수를 얻습니다
			int count = bdao.getCount( bvo.getNum() );
			// 조회된 댓글 갯수를 dto 에 업데이트
			bvo.setReplycnt( count );
		}
		
		return list;
	}

	public int getAllCount() {
		return bdao.getAllCount();
	}
}
