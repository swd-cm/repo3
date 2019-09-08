package cn.tedu.video.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.video.service.ex.InsertException;
import cn.tedu.video.service.ex.PasswordNotMatchException;
import cn.tedu.video.service.ex.ServiceException;
import cn.tedu.video.service.ex.UserNotFoundException;
import cn.tedu.video.service.ex.UsernameConflictException;
import cn.tedu.video.util.JsonResult;

public class BaseController {
	public static final int SUCCESS = 2000;
	public Integer getUid(HttpSession session){
		return (Integer) session.getAttribute("uid");
	}
	
	public String getUsername(HttpSession session){
		return (String) session.getAttribute("username");
	}
	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handlerException(Throwable e){
		JsonResult<Void> jsonResult = new JsonResult<>(e);
		if(e instanceof UsernameConflictException){
			jsonResult.setState(4001);
		}else if(e instanceof InsertException){
			jsonResult.setState(4002);
		}else if(e instanceof UserNotFoundException){
			jsonResult.setState(4003);
		}else if(e instanceof PasswordNotMatchException){
			jsonResult.setState(4004);
		}
		return jsonResult;
	}
}
