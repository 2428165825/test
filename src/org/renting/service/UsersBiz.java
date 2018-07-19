package org.renting.service;

import java.util.Iterator;
import java.util.List;

import org.renting.dao.HibernateUtil;
import org.renting.dao.UsersDao;
import org.renting.entity.House;
import org.renting.entity.Users;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;


public class UsersBiz {
	private UsersDao usersDao = new UsersDao();
	/**
	 * CH08上机4查询所有用户信息
	 */
	public List<Users> findAllUsersCH08(){
		Transaction tx =null;
		List<Users> users = null;
		try {
			tx = usersDao.currentSession().beginTransaction();
			users = usersDao.findAllUsersCH08();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return users;
	}
	/**
	 * CH08JD5查询登录用户
	 */
	public Users findByName(String name,String password) {
		Transaction tx = null;
		Users user = null;
		try {
			tx = usersDao.currentSession().beginTransaction();
			user = usersDao.findByName( name, password);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return user;
	}
	
	
}
