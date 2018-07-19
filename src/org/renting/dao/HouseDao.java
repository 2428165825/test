package org.renting.dao;

import java.util.Date;
import java.util.List;

import org.renting.entity.House;
import org.renting.entity.HouseCondition;
import org.hibernate.Query;

public class HouseDao extends BaseDao{
	/**
	 * CH08JD5查询登录的用户的发布的房屋信息
	 * @param id
	 * @return
	 */
	public List<House> findByU_Id(Integer id) {
		String hql = "from House h left join fetch h.streets where user_id = ?";
		Query query = currentSession().createQuery(hql).setParameter(0, id);
		return query.list();
	}
	/**
	 * CH09SJ5新增房屋发布信息
	 * @param house
	 */
	public void addHouseInfo(House house) {
		currentSession().save(house);
	}
	/**
	 * Ch10SJ2条件查询
	 * @param hql
	 * @param condition
	 * @return
	 */
	public List<House> findHouse(String hql,HouseCondition condition) {
		return currentSession().createQuery(hql).setProperties(condition).list();
	}
}
