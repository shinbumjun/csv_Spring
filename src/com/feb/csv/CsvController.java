package com.feb.csv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CsvController {
	
	public CsvController() {
		System.out.println("11111111111111111111111111111111");
	}
	
	@GetMapping("/csv/check-row-count.do")
	public ModelAndView csv() {
		System.out.println("22222222222222222222222222");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("csv");
		return mv;
	}
}
