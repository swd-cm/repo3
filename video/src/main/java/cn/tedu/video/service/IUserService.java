package cn.tedu.video.service;

import cn.tedu.video.entity.User;
/**
 *业务接口 
 */
public interface IUserService {
	/**
	 * 注册业务
	 * @param user注册数据
	 */
	void register(User user);
	/**
	 * 登录业务
	 * @param username客户的用户名
	 * @param password客户的密码
	 */
	User login(String username,String password);
	
	void updateVip(Integer id,String username);
}
