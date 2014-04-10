package test.restful.album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GlobalController {
	
	@RequestMapping("index")
	public String goHome(Model model){
		
		return "index";
	}
	
	
	@RequestMapping("showMessage")
	public String goShowMessage(Model model){
		String text = "It works!";
		model.addAttribute("message", text);
		
		return "showMessage";
	}

}
