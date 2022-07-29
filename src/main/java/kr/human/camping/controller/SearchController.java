package kr.human.camping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.human.camping.service.SearchService;

@Controller
public class SearchController {
	@Autowired
	SearchService searchService;
	
	@RequestMapping(value = "/search")
	public String search(Model model) {
		model.addAttribute("search", searchService.search());
		return "search";
	}
	
	
	
}
