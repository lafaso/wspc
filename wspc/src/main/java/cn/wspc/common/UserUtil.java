package cn.wspc.common;

import javax.servlet.http.HttpSession;

import cn.wspc.account.domain.User;

public class UserUtil {

	public static String USER = "cn.edu.wspc.user";

	public static User getCurrentUser() {
		Object object = getSession().getAttribute(USER);
		if (object == null) {
			throw new RuntimeException("用户未登录");
		}
		return (User) object;
	}

	public static void addUser(User user) {
		getSession().setAttribute(USER, user);
	}

	public static void removeUser() {
		getSession().removeAttribute(USER);
	}

	private static HttpSession getSession() {
		return SessionUtil.getSession();
	}
}
