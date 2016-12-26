package com.yj.yjsite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.dto.JSONResult;
import com.yj.yjsite.service.UsersService;

@Controller("usersAPIController")
@RequestMapping("/users/api")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkId(@RequestParam(value = "id", required = true, defaultValue = "") String id){

		//SingletonClass sc = SingletonClass.getInstance();
		boolean result = usersService.checkId(id);
		return JSONResult.success(result ? "exist" : "not exist");
	}

}
