package com.spring.restful.model;

import java.util.List;

public class Followers {

	private List<String> followEmail;
	private String userEmail;

	public Followers() {

	}

	public Followers(List<String> followEmail, String userEmail) {
		super();
		this.followEmail = followEmail;
		this.userEmail = userEmail;
	}

	public List<String> getFollowEmail() {
		return followEmail;
	}

	public void setFollowEmail(List<String> followEmail) {
		this.followEmail = followEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Followers [followEmail=" + followEmail + ", userEmail=" + userEmail + "]";
	}

}
