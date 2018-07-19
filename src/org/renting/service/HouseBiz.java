package org.renting.service;

import java.util.Calendar;
import java.util.List;

import org.renting.dao.HibernateUtil;
import org.renting.dao.HouseDao;
import org.renting.entity.House;
import org.renting.entity.HouseCondition;
import org.renting.entity.Users;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class HouseBiz {
	private HouseDao houseDao = new HouseDao();
	/**
	 * CH08JD5显示登录用户的发布的租房信息
	 */
	public List<House> findByU_Id(Integer id) {
		Transaction tx = null;
		List<House> house = null;
		try {
			tx = houseDao.currentSession().beginTransaction();
			house = houseDao.findByU_Id(id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return house;
	}
	/**
	 * CH09SJ5新增房屋发布信息
	 * @param house
	 */
	public void addHouseInfo(House house) {
		Transaction tx = null;
		try {
			tx = houseDao.currentSession().beginTransaction();
			houseDao.addHouseInfo(house);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}
	public List<House> findHouseByCondition(HouseCondition condition) {
		Transaction tx = null;
		List<House> house = null;
		try {
			tx = houseDao.currentSession().beginTransaction();
			//HQL根据动态生成
			StringBuilder hql = new StringBuilder("from House as house where 1=1");
			if (condition.getTitle() != null && condition.getTitle().length()>0) {
				hql.append(" and house.title like '%'||:title||'%'");
			}
			if (condition.getPrice() != null) {
				if (condition.getPrice() <100) {
					hql.append(" and house.price < :price");
				}else if (condition.getPrice() >=100 && condition.getPrice() <=200) {
					hql.append(" and house.price between 100 and 200");
				}else if (condition.getPrice() >400) {
					hql.append(" and house.price >:price");
				}
			}
			if (condition.getStreet_id() != null && condition.getStreet_id() !=0) {
				hql.append(" and house.street_id = :street_id");
			}
			if (condition.getType_id() !=null && condition.getType_id() !=0) {
				hql.append(" and house.type_id = :type_id");
			}
			if (condition.getFloorage() !=null && condition.getFloorage() !=0) {
				hql.append(" and house.floorage = :floorage");
			}
			house = houseDao.findHouse(hql.toString(), condition);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return house;
	}
}
