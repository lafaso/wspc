package cn.wspc.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PermissionDao {

	public List<String> findAllPermissions(@Param("userId") Integer userId);
}
