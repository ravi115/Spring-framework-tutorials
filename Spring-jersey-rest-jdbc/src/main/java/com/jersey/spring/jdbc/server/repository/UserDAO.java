package com.jersey.spring.jdbc.server.repository;

import java.sql.SQLException;
import java.util.List;

import com.jersey.spring.jdbc.server.model.User;

public interface UserDAO {

	 /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  //public void setDataSource(DataSource dataSource);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public void create(User user);
  
  /** 
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
 * @throws SQLException 
  */
  public User getUsers(Integer id);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<User> listUsers();
  
  /** 
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public void delete(Integer id);
  
  /** 
     * This is the method to be used to update
     * a record into the Student table.
  */
  public void update(Integer id, User user);
}
