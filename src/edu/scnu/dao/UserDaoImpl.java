package edu.scnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import edu.scnu.bean.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Override
	public void save(User u) {
		String sql = "insert into sys_user values(null, ?,?,?,?,?)";
		super.getJdbcTemplate().update(sql, u.getUser_code(), u.getUser_name(),
							u.getUser_password(), u.getUser_state(), u.getAccount());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from sys_user where user_id=?";
		super.getJdbcTemplate().update(sql, id);
	}

	@Override
	public void update(User u) {
		String sql = "update sys_user set user_name=? where user_id=?";
		super.getJdbcTemplate().update(sql, u.getUser_name(), u.getUser_id());
	}

	@Override
	public User getById(Integer id) {
		String sql = "select * from sys_user where user_id = ?";
		return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {
				User u = new User(rs.getInt("user_id"), rs.getString("user_code"),
						rs.getString("user_name"), rs.getString("user_password"),
						rs.getString("user_state").toCharArray()[0], rs.getDouble("account"));
				return u;
			}
			
		}, id);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from sys_user";
		Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from sys_user";
		return super.getJdbcTemplate().query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {
				User u = new User(rs.getInt("user_id"), rs.getString("user_code"),
						rs.getString("user_name"), rs.getString("user_password"),
						rs.getString("user_state").toCharArray()[0], rs.getDouble("account"));
				return u;
			}
			
		});
	}

	@Override
	public void increaseAccount(Integer id, Double money) {
		String sql = "update sys_user set account=account+? where user_id=?";
		super.getJdbcTemplate().update(sql, money, id);
	}

	@Override
	public void decreaseAccount(Integer id, Double money) {
		String sql = "update sys_user set account=account-? where user_id=?";
		super.getJdbcTemplate().update(sql, money, id);
	}
}
