package edu.scnu.dao;

import java.util.List;

import edu.scnu.bean.User;

public interface UserDao {
	void save(User u);
	void delete(Integer id);
	void update(User u);
	User getById(Integer id);
	int getTotalCount();
	List<User> getAll();
	void increaseAccount(Integer id, Double money);
	void decreaseAccount(Integer id, Double money);
}
