package net.nsimpler.application.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.nsimpler.application.helpers.admin.AccountRegistRequest;


@Controller
@RequestMapping("/admin/accountresult")
public class AccountresultController{
	

	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create( AccountRegistRequest AccountRegReq){
		System.out.printf("POST.build()  accountresult/create실행 \n");
		return "account/result";
	}
}
