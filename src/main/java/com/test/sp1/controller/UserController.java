package com.test.sp1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.sp1.entity.User;
import com.test.sp1.service.UserService;
@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public @ResponseBody List<User> getUserList(){
		List<User> userList = userService.getUserList();
		log.debug("debug : userList=>{} ,{}", userList, userList);
		log.info("info : userList=>{} ,{}", userList, userList);
		return userList;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public @ResponseBody Long insertUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam long uiNum) {
		log.debug("uiNum은 => {}", uiNum);
		return userService.getUser(uiNum);
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public @ResponseBody Long updateUser(@RequestBody User user) {
		log.debug("user => {}", user);
		return userService.updateUser(user); 
	}
	
	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public @ResponseBody Long deleteUser(@RequestBody User user) {
		log.debug("uiNum => {}", user.getUiNum());
		return userService.deleteUser(user.getUiNum());
	}
}
