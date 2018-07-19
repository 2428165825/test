package org.text;

import static org.junit.Assert.*;

import java.util.List;

import org.renting.entity.House;
import org.renting.entity.Users;
import org.renting.service.HouseBiz;
import org.renting.service.UsersBiz;

public class Test {

	@org.junit.Test
	public void test() {
		List<Users>list= new UsersBiz().findAllUsersCH08();
		for (Users users : list) {
			System.out.println(users.getName());
		}
	}
	@org.junit.Test
	public void test1() {
		List<House>list= new HouseBiz().findByU_Id(1);
		for (House users : list) {
			System.out.println(users.getStreets().getName());
		}
	}
}
