package cn.wspc.account.vo;

import org.apache.commons.lang.StringUtils;

public class UserVo {
	private String id;
	private String name;
	private String age;
	private String gender;
	private String certificateNo;
	private String certificateType;
	private String fullName;
	private String password;
	private String password2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public String toString() {
		return "StudentAccountView [id=" + id + ", name=" + name + ", age="
				+ age + ", gender=" + gender + ", certificateNo="
				+ certificateNo + ", certificateType=" + certificateType
				+ ", fullName=" + fullName + ", password=" + password
				+ ", password2=" + password2 + "]";
	}
	
	/**
	 * private String name;
	private String age;
	private String gender;
	private String certificateNo;
	private String certificateType;
	private String fullName;
	private String password;
	private String password2;
	 * @return
	 */
	
	public String validateRegister(){
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isBlank(name)){
			sb.append("名字不能为空<br>");
		}
		if(StringUtils.isBlank(age)){
			sb.append("年龄不能为空<br>");
		}
		if(StringUtils.isBlank(gender)){
			sb.append("性别不能为空<br>");
		}
		if(StringUtils.isBlank(certificateNo)){
			sb.append("证件号不能为空<br>");
		}
		if(StringUtils.isBlank(certificateType)){
			sb.append("证件类型不能为空<br>");
		}
		if(StringUtils.isBlank(fullName)){
			sb.append("全名不能为空<br>");
		}
		if(StringUtils.isBlank(password) || StringUtils.isBlank(password2)){
			sb.append("密码或确认密码不能为空<br>");
		}
		if(!StringUtils.equals(password, password2)){
			sb.append("前后密码不一致<br>");
		}
		return sb.toString();
	}
	
	public String validateLogin(){
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isBlank(certificateNo)){
			sb.append("证件号不能为空<br>");
		}
		if(StringUtils.isBlank(certificateType)){
			sb.append("证件类型不能为空<br>");
		}
		if(StringUtils.isBlank(password)){
			sb.append("密码不能为空<br>");
		}
		return sb.toString();
	}
}
