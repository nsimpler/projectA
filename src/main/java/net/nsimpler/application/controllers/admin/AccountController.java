package net.nsimpler.application.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/account")
public class AccountController{
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login( @RequestParam("id") String userId,
						 @RequestParam(value="orderId",required=false,defaultValue="0") long orderId, Model model){
		System.out.printf("POST.build() 실행 \n");

		model.addAttribute("id",userId);
		model.addAttribute("orderId",orderId);
		
		return "account/login";
	}
		
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String create( @RequestParam("id") String userId,
						  @RequestParam(value="orderId",required=false,defaultValue="0") long orderId, Model model){
		System.out.printf("POST.build() 실행 \n");

		model.addAttribute("id",userId);
		model.addAttribute("orderId",orderId);
		return "account/create";
	}
	
	
	
}
