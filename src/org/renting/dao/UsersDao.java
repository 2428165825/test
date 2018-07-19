package org.renting.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.renting.entity.House;
import org.renting.entity.Users;

public class UsersDao extends BaseDao{
	//查询租房用户表
	//CH08SJ4查询所有
	public List<Users> findAllUsersCH08(){
		String hql = "from Users";
		Query query = currentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * CH08JD5查询登录用户
	 */
	public Users findByName(String name,String password) {
		String hql = "from Users where name = ? and password = ?";
		Query query = currentSession().createQuery(hql).setParameter(0, name).setParameter(1, password);
		return (Users) query.uniqueResult();
	}
}
