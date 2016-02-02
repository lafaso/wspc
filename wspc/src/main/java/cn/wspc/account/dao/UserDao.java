package cn.wspc.account.dao;

import org.apache.ibatis.annotations.Param;

import cn.wspc.account.domain.User;

public interface UserDao {

	public User find(@Param("certificateNo") String certificateNo,
			@Param("certificateType") String certificateType);
	
	public User findByPwd(@Param("certificateNo") String certificateNo,
			@Param("certificateType") String certificateType, @Param("password") String password);

	public void insert(User studentAccount);
	
	public void update(User studentAccount);
}
