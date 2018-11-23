package edu.scnu.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.scnu.bean.User;
import edu.scnu.dao.UserDao;
import edu.scnu.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJdbc {
	@Resource(name="userDao")
	private UserDao ud;
	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void testSave() {
		User u = new User();
		u.setUser_name("测试用户");
		u.setUser_state('0');
		u.setAccount(1000d);
		ud.save(u);
	}
	
	@Test
	public void testUpdate() {
		User u = new User();
		u.setUser_name("测试用户2");
		ud.update(u);
	}
	
	@Test
	public void testDelete() {
		ud.delete(7);
	}
	
	@Test
	public void testFind() {
		System.out.println(ud.getById(7));
		System.out.println(ud.getAll());
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
