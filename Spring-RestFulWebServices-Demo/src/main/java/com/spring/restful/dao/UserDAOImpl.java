package com.spring.restful.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.restful.model.Followers;
import com.spring.restful.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	/**
	 * 
	 */
	@Override
	public List<User> listUser() {

		return mongoTemplate.findAll(User.class);
	}

	/**
	 * 
	 */
	@Override
	public void add(User user) {
		if(!mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.createCollection(User.class);
		}
		mongoTemplate.save(user);
	}

	/**
	 * 
	 */
	@Override
	public List<User> getFollowers(final String email) {

		List<User> folowersUser = new ArrayList<>();

		User user = (User) SearchQuery("email", email);
		if(null != user) {

			List<String> followers = user.getFollowers();

			for(String follower : followers ) {

				User tempUser = (User) SearchQuery("email", follower);
				if(null != tempUser ) {
					folowersUser.add(tempUser);
				}
			}
		}
		return folowersUser;
	}

	/**
	 * API to search document based on the fields.
	 * 
	 * @param field which is available in documents.
	 * @param searchItem data.
	 * @return documents
	 */
	private Object SearchQuery(final String field, final String searchItem) {

		Object obj;

		Query searchQuery = new Query(Criteria.where(field).is(searchItem));
		obj = mongoTemplate.findOne(searchQuery, User.class);

		return obj;
	}

	/**
	 * 
	 */
	@Override
	public void followUser(final Followers followers) {

		for(String email : followers.getFollowEmail()) {
			User user = (User) SearchQuery("email", email);

			if(null != user ) {
				if(user.getFollowers() == null ) {
					user.setFollowers(new ArrayList<String>());
				}
				user.getFollowers().add(followers.getUserEmail());
				add(user);
			}
		}
	}

	@Override
	public boolean isUserExist(User user ) {

		boolean bIsExists = false;

		user = (User) SearchQuery("email", user.getEmail());
		if(user != null && user.getEmail().length() > 0 ) {
			bIsExists = true;
		}
		return bIsExists;
	}


}
