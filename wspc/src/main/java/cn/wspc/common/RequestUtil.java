package cn.wspc.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestUtil {

	public static HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder
				.getRequestAttributes();
		Assert.notNull(requestAttributes);
		return ((ServletRequestAttributes) requestAttributes).getRequest();
	}
}
