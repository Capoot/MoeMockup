package moemockup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index/**")
public class IndexController {

	@RequestMapping("/show")
	public String index() {
		System.out.println("Index");
		return "index";
	}
}
