package cn.wspc.common;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.wspc.account.domain.User;

@Component
public class PermissionHolder {

	public boolean hasPermission(String url) {
		User user = UserUtil.getCurrentUser();
		List<String> permissions = user.getPermissions();
		return permissions.contains(url);
	}
}
