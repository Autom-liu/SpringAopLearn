package edu.scnu.service;

import java.util.List;

import edu.scnu.bean.User;

public interface UserService {
	void save(User u);
	void transfer(Integer from, Integer to, Double money);
	User find(Integer id);
	List<User> getAll();
}
