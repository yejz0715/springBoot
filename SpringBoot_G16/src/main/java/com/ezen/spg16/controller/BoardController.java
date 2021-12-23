package com.ezen.spg16.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.spg16.dto.BoardVO;
import com.ezen.spg16.dto.Paging;
import com.ezen.spg16.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@RequestMapping("/main")
	public ModelAndView goMain(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		if( session.getAttribute("loginUser") == null)	
			mav.setViewName("loginform");
		else {
			int page=1;
			
			if( request.getParameter("page") != null ) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			}else if( session.getAttribute("page")!= null  ) { 
				page = (int) session.getAttribute("page");
			} else { 
				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			int count = bs.getAllCount();
			paging.setTotalCount( count );
			paging.paging();
			
			mav.addObject("boardList", bs.selectBoardAll( paging ) );
			mav.addObject("paging", paging);
			mav.setViewName("main");
		}
		return mav;
	}
	
	
	
	@RequestMapping("/boardWriteForm")
	public String write_form(Model model, HttpServletRequest request) {
		String url = "board/boardWriteForm";
		HttpSession session = request.getSession();
		if( session.getAttribute("loginUser") == null)	url="loginform";		
		return url;
	}
	
	
	@RequestMapping(value="boardWrite", method = RequestMethod.POST)
	public String board_write( @ModelAttribute("dto") @Valid BoardVO boardvo, 
			BindingResult result, Model model,	HttpServletRequest request) {
		
		if( result.getFieldError("pass")!=null) {
			return "board/boardWriteForm";
		}else  if(result.getFieldError("title")!=null) {
			return "board/boardWriteForm";
		}else if(result.getFieldError("content")!=null) {
			return "board/boardWriteForm";
		}else {
			// bs.insertBoard(boardvo);
			return "redirect:/main";
		}
		
		
	}
		
}











