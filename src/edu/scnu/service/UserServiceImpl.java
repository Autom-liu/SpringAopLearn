package edu.scnu.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.scnu.bean.User;
import edu.scnu.dao.UserDao;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class UserServiceImpl implements UserService {
	
	private UserDao ud;

	
	
	@Override
	public void transfer(Integer from, Integer to, Double money) {
		ud.decreaseAccount(from, money);

		ud.increaseAccount(to, money);
	}

	@Override
	public void save(User u) {
		ud.save(u);
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public User find(Integer id) {
		return ud.getById(id);
	}
	
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public List<User> getAll() {
		return ud.getAll();
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}


}
