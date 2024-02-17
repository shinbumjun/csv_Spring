package com.feb.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CsvController {
	
	public CsvController() {
		System.out.println("11111111111111111111111111111111");
	}
	
	@GetMapping("/csv")
	public ModelAndView csv() {
		System.out.println("2222222222222222222222222222222222222");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("csv");
		return mv;
	}
	
	@PostMapping("/csv/check-row-count.do")
	public ModelAndView check(@RequestParam("csv") MultipartFile csvFile) throws IOException{
		System.out.println("3333333333333333333333333333333333");
		
		System.out.println("csvFile : " + csvFile);
		// 업로드된 파일의 원본 파일 이름을 반환
		System.out.println("Uploaded file: " + csvFile.getOriginalFilename()); // member.csv
		// 업로드된 파일의 크기를 반환
		System.out.println("File size: " + csvFile.getSize()); // 231

		// 파일의 내용을 문자열로 읽어오기, 한글 깨짐
//	    String content = new String(csvFile.getBytes(), StandardCharsets.UTF_8);
//	    System.out.println("File content: " + content);
		String content = IOUtils.toString(csvFile.getInputStream(), "EUC-KR");
		System.out.println("File content: " + content);
	    
		ModelAndView mv = new ModelAndView();
		mv.setViewName("check");
		return mv;
	}
}
