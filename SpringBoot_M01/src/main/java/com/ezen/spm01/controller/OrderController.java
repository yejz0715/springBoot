package com.ezen.spm01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.ezen.spm01.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService os;
}
