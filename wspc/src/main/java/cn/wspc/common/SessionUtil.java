package cn.wspc.common;

import javax.servlet.http.HttpSession;

public class SessionUtil {

	public static HttpSession getSession() {
		HttpSession session = RequestUtil.getRequest().getSession();
		if (session == null) {
			throw new RuntimeException("用户未登录");
		}
		return session;
	}
}
