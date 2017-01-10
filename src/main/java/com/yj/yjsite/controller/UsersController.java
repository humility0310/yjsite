package com.yj.yjsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yj.security.Auth;
import com.yj.security.AuthUser;
import com.yj.yjsite.service.UsersService;
import com.yj.yjsite.vo.UsersVo;

@Controller
@RequestMapping("")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping("/login")
	public String login() {
		return "users/loginform";
	}

	@Auth
	@RequestMapping("/modifyform")
	public String modifyform(@ModelAttribute UsersVo usersVo) {
		return "users/modifyform";
	}

	@Auth
	@RequestMapping("/modifyresult")
	public String modifyresult(@AuthUser UsersVo authUser, @ModelAttribute @Valid UsersVo usersVo, BindingResult result,
			Model model, @RequestParam(value = "usersImage1") MultipartFile file) {

		if (result.hasErrors()) {
			return "/users/modifyform";
		}
		authUser.setPassword(usersVo.getPassword());
		authUser.setUsersImage(usersService.restore(file));
		usersService.modify(authUser);
		return "redirect:/";
	}

	// @RequestMapping("/loginresult")
	// public String loginresult(@ModelAttribute @Valid UsersVo usersVo,
	// BindingResult result, Model model) {
	// if (result.hasErrors()) {
	// // model.addAllAttributes(result.getModel());
	//
	// return "/users/loginform";
	// }
	//
	// System.out.println(usersVo.toString());
	// return "";
	// }

	@RequestMapping("/join")
	public String join(@ModelAttribute UsersVo usersVo) {
		return "users/join";
	}

	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinSuccess";
	}

	@RequestMapping(value = "/joinresult", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UsersVo usersVo, BindingResult result,
			@RequestParam(value = "usersImage1") MultipartFile file) {

		if (result.hasErrors()) {
			// model.addAllAttributes(result.getModel());

			return "/users/join";
		}
		usersService.join(usersVo);
		usersVo.setUsersImage(usersService.restore(file));
		return "redirect:/joinsuccess";
	}
}
