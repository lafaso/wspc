package cn.wspc.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wspc.common.dao.PermissionDao;

@Service
public class PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	public List<String> getAllPermissions(Integer userId) {
		return permissionDao.findAllPermissions(userId);
	}
}
