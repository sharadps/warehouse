package com.app.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public void saveUser(User user) {
		// sf.getCurrentSession().save(user);
		ht.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByEmail(String userEmail) {
		User user = null;
		List<User> users = (List<User>) ht
				.findByCriteria(DetachedCriteria.forClass(User.class).add(Restrictions.eq("userEmail", userEmail)));
		if (users != null && !users.isEmpty()) {
			user = users.get(0);
		}
		return user;

	}

	@Override
	public List<User> getAllUser() {
		return ht.loadAll(User.class);
	}

}
