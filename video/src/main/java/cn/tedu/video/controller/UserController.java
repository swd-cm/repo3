package cn.tedu.video.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.video.entity.User;
import cn.tedu.video.service.IUserService;
import cn.tedu.video.util.JsonResult;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private IUserService userService;
	@RequestMapping("/register")
	public JsonResult<Void> register(User user){
		JsonResult<Void> jsonResult = new JsonResult<>();
		userService.register(user);
		return new JsonResult<>(SUCCESS);
	}
	@RequestMapping("/login")
	public JsonResult<Void> login(String username,String password,HttpSession session){
		JsonResult<Void> jsonResult = new JsonResult<>();
		User user = userService.login(username, password);
		session.setAttribute("uid",user.getId());
		session.setAttribute("username",user.getUsername());
		return new JsonResult<>(SUCCESS);
	}
	
	@RequestMapping("update_vip")
	public JsonResult<Void> a(HttpSession session){
		String username = getUsername(session);
		Integer id = getUid(session);
		userService.updateVip(id, username);
		return new JsonResult<>(SUCCESS);
	}
}
