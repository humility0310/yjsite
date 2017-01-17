package com.yj.yjsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.dto.JSONResult;
import com.yj.yjsite.service.UsersService;
import com.yj.yjsite.vo.UsersVo;

@Controller
@RequestMapping("")
public class MainController {

	@Autowired
	UsersService usersService;
/*
	@RequestMapping("")
	public String main() {
		return "main/main";
	}*/

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "테스트 입니다.";
	}

	@RequestMapping("")
	public String test() {
		return "test/test";
	}

	// ---------------JSON URL로 확인-------------------------
	@ResponseBody
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public JSONResult test3() {
		return JSONResult.success(usersService.getUsersInfo("11"));
	}

	// --------------JSON 보냄 ----------------------------
	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public JSONResult getUserInfo() {
		System.out.println("test2 들어감");
		return JSONResult.success(usersService.getUsersInfo("11"));
	}

	// --------------JSON 받음 ---------------------------------
	@ResponseBody
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public JSONResult inputJSON(@ModelAttribute UsersVo vo) {
		System.out.println("test1 들어감");
		System.out.println(vo);
		return JSONResult.success(1);
	}

	// ------------------JSON List----------------------------
	@ResponseBody
	@RequestMapping(value = "testlist", method = RequestMethod.POST)
	public JSONResult getList() {
		List<UsersVo> list = usersService.getList();
		return JSONResult.success(list);
	}
}
