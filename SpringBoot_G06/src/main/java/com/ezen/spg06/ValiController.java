package com.ezen.spg06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValiController {

	@RequestMapping("/")
	public String main() {
		return "startPage";
	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("dto") ContentDto contentdto, Model model,
			BindingResult result) {
		
		//매개변수에 Dto객체를 변수로 넣으면 전달되어지는 파라미터들이 객체내의 동일한 이름의 멤버변수에 자동 대입됩니다
		//write-> contentdto.writer   content->contentdto.content
		
		//추가로 contentdto라는 이름으로 객체가 model객체에 추가되서 최종 jsp파일에 전달됩니다
		
		//매개변수 객체(매개변수)앞에 ModelAttrivute(전달이름)을 붙이면,
		//return되는 페이지에 해당 객체가 .model.addAttribute로 넣은것처럼
		//같이 전달됩니다. model.addAttribute("dto", contentdto); 와 동일한 동작
		
		//전달된 파라미터가 비어있거나 널이라면, 그 값을 갖고 원래의 페이지로 돌아가고,
		//유효한 데이터라면 DonePage.jsp로 전송됨
		if(true) {
			model.addAttribute("message", "writer 또는 content를 입력하세요");
			return "startPage";
		}
		return "DonePage";
	}
}
