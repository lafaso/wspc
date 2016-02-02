package cn.wspc.common;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

public class PermissionDirectiveModel implements TemplateDirectiveModel {

	@Autowired
	private PermissionHolder permissionHolder;

	public void execute(Environment env,
			@SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		Object urlParam = params.get("url");
		if (params == null || urlParam == null) {
			throw new RuntimeException("参数不能为空");
		}
		String url = ((TemplateScalarModel) urlParam).getAsString();
		if (body != null) {
			if (permissionHolder.hasPermission(url)) {
				body.render(env.getOut());
			}
		}
	}

}
