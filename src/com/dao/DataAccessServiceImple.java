package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.LoginBean;
import com.entity.User;

public class DataAccessServiceImple implements DataAccessService {
	Session session = null;

	public boolean Authenticate(LoginBean bean) {
		boolean flag = false;
		session = SessionUtil.getSession();

		Query query = session.createQuery("from User u");

		List<User> list = query.list();
		for (User eachuser : list) {
			if (eachuser.getUsername().equals(bean.getUsername())
					&& eachuser.getPassword().equals(bean.getPassword())) {
				flag = true;

			}

		}

		return flag;
	}

	public void saveUser(User user) {
		session = SessionUtil.getSession();

		Transaction transaction = session.beginTransaction();
		if (!transaction.isActive()) {
			transaction.begin();
		}
		session.saveOrUpdate(user);
		transaction.commit();
		System.out.println("Object saved in database successfully");
        session.close();


	}

}
