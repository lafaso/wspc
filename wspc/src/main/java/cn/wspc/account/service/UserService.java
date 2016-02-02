package cn.wspc.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wspc.account.dao.UserDao;
import cn.wspc.account.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao studentAccountDao;

	public User find(String certificateNo, String certificateType) {
		User studentAccount = studentAccountDao.find(certificateNo,
				certificateType);
		return studentAccount;
	};

	public void insert(User studentAccount) {
		studentAccountDao.insert(studentAccount);
	};
	
	public void update(User studentAccount) {
		studentAccountDao.update(studentAccount);
	}

	public User findByPwd(String certificateNo, String certificateType,
			String password) {
		return studentAccountDao.findByPwd(certificateNo, certificateType, password);
	};
}
