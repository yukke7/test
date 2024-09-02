package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * SecurityFilterChainクラス送られてきた
 * リクエストを処理するControllerクラス
 */
@Controller
public class loginController {
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}

}
