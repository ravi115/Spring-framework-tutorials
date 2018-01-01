package com.jersey.spring.server.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.server.model.Motor;
import com.jersey.spring.server.model.MotorBikes;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Motor> getAllMotorBikes() {

		List<Motor> motorBikes = null;

		System.out.println("called getb method of motor bikes..........");
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("deprecation")
		Query<Motor> query = session.createQuery("from Motor", Motor.class);

		motorBikes = query.getResultList();
		return motorBikes;
	}

	@Override
	public void save(Motor motorBikes) {

		System.out.println("called save method......");
		Session session = sessionFactory.getCurrentSession();

		session.save(motorBikes);

	}

	@Override
	public Motor getMotorCycle(int id) {
		System.out.println("called getb method of motor bikes..........with id : " + id);
		Session session = sessionFactory.getCurrentSession();
		
		Motor motor = session.get(Motor.class, id);
		System.out.println(motor);
		return motor;
	}

}
