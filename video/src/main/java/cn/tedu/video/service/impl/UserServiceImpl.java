package cn.tedu.video.service.impl;

import java.util.UUID;

import org.apache.tomcat.util.digester.Digester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.video.entity.User;
import cn.tedu.video.mapper.UserMapper;
import cn.tedu.video.service.IUserService;
import cn.tedu.video.service.ex.InsertException;
import cn.tedu.video.service.ex.PasswordNotMatchException;
import cn.tedu.video.service.ex.UpdateException;
import cn.tedu.video.service.ex.UserNotFoundException;
import cn.tedu.video.service.ex.UsernameConflictException;
/**
 * 业务实现类
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserMapper userMapper;
	@Override
	public void register(User user) {
		String username = user.getUsername();
		User result = userMapper.findByUsername(username);
		if(result!=null){
			throw new UsernameConflictException("用户名("+username+")已经被占用");
		}
		String salt = UUID.randomUUID().toString().toUpperCase();
		String password = getMd5Password(user.getPassword(), salt);
		user.setSalt(salt);
		user.setPassword(password);
		user.setIsDelete(0);
		Integer row = userMapper.insert(user);
		if(row!=1){
			throw new InsertException("添加数据时出现未知错误");
		}
	}
	@Override
	public User login(String username, String password) {
		User result = userMapper.findByUsername(username);
		if(result==null){
			throw new UserNotFoundException("此用户("+username+")不存在");
		}else{
			String salt = result.getSalt();
			String pwd = result.getPassword();
			password = getMd5Password(password, salt);
			if(!pwd.equals(password)){
				throw new PasswordNotMatchException("密码错误！");
			}
		}
		return result;
	}
	
	@Override
	public void updateVip(Integer id,String username) {
		User result = userMapper.findByUsername(username);
		if(result==null){
			throw new UserNotFoundException("此用户("+username+")不存在");
		}
		Integer row = userMapper.updateVip(id);
		if(row!=1){
			throw new UpdateException("更新异常");
		}
	}
	private String getMd5Password(String password,String salt){
		String str = salt+password+salt;
		for(int i=0;i<5;i++){
			str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		return str;
	}
}
