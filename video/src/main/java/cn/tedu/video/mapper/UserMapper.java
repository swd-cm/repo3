package cn.tedu.video.mapper;

import cn.tedu.video.entity.User;

/**
 * 放置功能抽象方法的接口
 */
public interface UserMapper {
	/**
	 * 向表中插入数据
	 * @param user要插入的数据
	 * @return操作条数
	 */
	Integer insert(User user);
	/**
	 * 根据用户名查询，如果查不到返回null
	 * @param username查询条件
	 * @return查询到的结果
	 */
	User findByUsername(String username);
	
	/**
	 * 修改用户是否为VIP
	 * @param uid用户登录时的uid
	 * @return受影响行数
	 */
	Integer updateVip(Integer uid);
}
