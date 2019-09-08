package cn.tedu.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.video.entity.User;
import cn.tedu.video.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	UserMapper userMapper;

	@Test
	public void insert() {
		User user = new User();
		user.setUsername("swd");
		user.setPassword("123456");
		user.setPhone("17695748297");
		Integer row = userMapper.insert(user);
		System.out.println(row);
	}

	@Test
	public void findByUsername() {
		String username = "swd";
		User user = userMapper.findByUsername(username);
		System.out.println(user);
	}
}
