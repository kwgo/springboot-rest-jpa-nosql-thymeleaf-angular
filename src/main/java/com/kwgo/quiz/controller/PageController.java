package com.kwgo.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * Controller class to response the page request
 *
 */
@Controller
public class PageController {

	/**
	 * Root mapping
	 */
	@GetMapping({ "", "/", "/climate", "/climate/" })
	public String homePage(Model model) {
		return "climate";
	}

}
