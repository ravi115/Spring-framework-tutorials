package com.jersey.spring.jdbc.server.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jersey.spring.jdbc.server.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(User user) {

		long time = System.currentTimeMillis();

		Date date = new Date(time); 

		String query = "INSERT into users (name, age, date, updated) "
				+ "values (?, ?, ?, ?)";

		int n = jdbcTemplate.update(query, user.getName(), user.getAge(), date, null);
		System.out.println("value of n : " + n);
	}

	@Override
	public User getUsers(Integer id) {

		String query = "select * from users where id = " + id;
		User user = new User();
		jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				if (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setName(resultSet.getString("Name"));
					user.setAge(resultSet.getInt("age"));
				}
				return user;
			}
		});

		return user;
	}

	@Override
	public List<User> listUsers() {

		String query = "SELECT * from users";

		List<User> listContact = jdbcTemplate.query(query, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));

				return user;
			}
		});
		return listContact;
	}

	@Override
	public void delete(Integer id) {

		String query = "DELETE FROM users where id = ?";

		int n = jdbcTemplate.update(query, id);

		if(n > 0) {
			System.out.println("users is deleted with id : " + id);
		}
	}

	public void update(Integer id, User user) {

		long time = System.currentTimeMillis();

		Date updated = new Date(time);
		
		String query = "UPDATE users SET name=?, age=?, updated=? WHERE id=?";
		
		User theUser = getUsers(id);
		if(null == theUser) {
			System.out.println("user doesn't exists...");
			return;
		}
		
		if(user.getName() == null) {
			user.setName(theUser.getName());
		}
		if(user.getAge() == 0) {
			user.setAge(theUser.getAge());
		}
		
		int n = jdbcTemplate.update(query, user.getName(), user.getAge(), updated, id);
		if(n > 0) {
			System.out.println("user hasbeen updated....!!");
		}
	}



}
