package net.nsimpler.application.controllers.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/action/user")
public class UserController{
		
	@RequestMapping(value="/create",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String create( @RequestParam("id") String userId,
						  @RequestParam(value="orderId",required=false,defaultValue="0") long orderId, Model model){
		System.out.printf("POST.build() 실행 \n");

		model.addAttribute("id",userId);
		model.addAttribute("orderId",orderId);
		return model.toString();
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String login( @RequestParam("id") String userId,
						 @RequestParam(value="orderId",required=false,defaultValue="0") long orderId, Model model){
		System.out.printf("POST.build() 실행 \n");

		model.addAttribute("id",userId);
		model.addAttribute("orderId",orderId);
		return model.toString();
	}
}
