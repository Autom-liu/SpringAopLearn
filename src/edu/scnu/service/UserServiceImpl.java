package edu.scnu.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import edu.scnu.dao.UserDao;

public class UserServiceImpl implements UserService {
	
	private UserDao ud;

	@Override
	public void transfer(Integer from, Integer to, Double money) {
		ud.decreaseAccount(from, money);
	
		ud.increaseAccount(to, money);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
