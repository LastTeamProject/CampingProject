package kr.human.camping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import kr.human.camping.service.MemberService;
import kr.human.camping.vo.MemberVO;

@Controller("MemberController")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	// 로그인
	// 회원정보가져오기
	// 로그아웃
	// 가입메일 전송하기
	// 임시비밀번호 발급
	// 
	
	@Bean
	public SpringSecurityDialect securityDialect(){
		return new SpringSecurityDialect();
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Model model ) {
		if(error!=null) model.addAttribute("error","error");
		if(logout!=null) model.addAttribute("logout","logout");
		return "login";
	}
	
	// 회원가입
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertMemeber(@ModelAttribute MemberVO memberVO, Model model) {
		System.out.println(memberVO);
		memberService.MemberInsert(memberVO);
		model.addAttribute("memberVO",memberVO);
		
		return "insertOk";
	} 
	
	// IdOverlap
	@RequestMapping(value = "/IdOverlap", method = RequestMethod.GET)
	public String IdCheck(@ModelAttribute String id, Model model) {
		System.out.println(id);
		int result = 0;
		result = memberService.IDOverlap(id);
		model.addAttribute("data",result);
		return "login";
	}
	
	// EmailOverlap
	@RequestMapping(value = "/EmailOverlap", method = RequestMethod.GET)
	public String EmailCheck(@ModelAttribute String email, Model model) {
		System.out.println(email);
		int result = 0;
		result = memberService.IDOverlap(email);
		model.addAttribute("data",result);
		return "login";
	}
	
	
	
	
}
