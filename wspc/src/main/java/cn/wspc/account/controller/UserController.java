package cn.wspc.account.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wspc.account.domain.User;
import cn.wspc.account.service.UserService;
import cn.wspc.account.vo.UserVo;
import cn.wspc.common.UserUtil;
import cn.wspc.common.service.PermissionService;

/**
 * 陪伴是长情的告白。 今晚月色真美。 you are the apple of my eyes。
 * 
 * @author ZHIPENG
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService studentAccountService;

	@Autowired
	private PermissionService permissionService;

	@RequestMapping("/")
	public String welcome() {
		System.out.println("====welcome===");
		return "welcome";
	}

	@RequestMapping("/register/input")
	public String toRegister(ModelMap modelMap) {
		System.out.println("====register input===");
		return "account/register";
	}

	@RequestMapping("/register/input/confirm")
	public String registerInputConfirm(ModelMap modelMap, UserVo vo) {
		String errMsg = validate(vo, false);
		if (StringUtils.isNotBlank(errMsg)) {
			modelMap.put("errMsg", errMsg);
			return "account/register";
		}
		studentAccountService.insert(toPo(vo));
		return "account/registerSuccess";
	}

	@RequestMapping("/login/input")
	public String toLogin(ModelMap modelMap) {
		System.out.println("===login input====");
		return "account/login";
	}

	@RequestMapping("/login/input/confirm")
	public String login(ModelMap modelMap, UserVo vo, HttpSession session) {
		System.out.println("===user login====");
		String errMsg = validate(vo, true);
		if (StringUtils.isNotBlank(errMsg)) {
			modelMap.put("errMsg", errMsg);
			return "account/login";
		}
		User user = getUserByPwd(vo);
		List<String> permissions = permissionService.getAllPermissions(user
				.getId());
		user.setPermissions(permissions);
		UserUtil.addUser(user);
		modelMap.put("user", user);
		return "main";
	}

	private User toPo(UserVo vo) {
		User sa = new User();
		sa.setAge(Integer.parseInt(vo.getAge()));
		sa.setCertificateNo(vo.getCertificateNo());
		sa.setCertificateType(vo.getCertificateType());
		sa.setFullName(vo.getFullName());
		sa.setName(vo.getName());
		sa.setGender(vo.getGender());
		sa.setLastUpdateTime(new java.sql.Timestamp(new Date().getTime()));
		sa.setOpenAccountDate(new java.sql.Timestamp(new Date().getTime()));
		sa.setPassword(vo.getPassword());
		return sa;
	}

	private String validate(UserVo vo, boolean isLogin) {
		String errMsg = null;
		if (isLogin) {
			errMsg = vo.validateLogin();
			if (StringUtils.isNotBlank(errMsg)) {
				return errMsg;
			}
			if (getUserByPwd(vo) == null) {
				errMsg = "用户名或密码错误";
			}
		} else {
			errMsg = vo.validateRegister();
			if (StringUtils.isNotBlank(errMsg)) {
				return errMsg;
			}
			if (getStudentAccount(vo) != null) {
				errMsg = "该用户已存在！";
			}
		}
		return errMsg;
	}

	private User getStudentAccount(UserVo vo) {
		User studentAccount = studentAccountService.find(vo.getCertificateNo(),
				vo.getCertificateType());
		return studentAccount;
	}

	private User getUserByPwd(UserVo vo) {
		User account = studentAccountService.findByPwd(vo.getCertificateNo(),
				vo.getCertificateType(), vo.getPassword());
		return account;
	}

}
