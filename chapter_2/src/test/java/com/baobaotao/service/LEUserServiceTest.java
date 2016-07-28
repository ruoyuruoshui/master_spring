package com.baobaotao.service;

import static org.junit.Assert.*;
import java.util.Date;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.baobaotao.domain.User;
import com.baobaotao.service.LEUserService;;

//基于 JUNit4 的测试框架
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})

public class LEUserServiceTest {
	@Autowired
	private LEUserService userService;
	
	@Test
	public void hasMatchUser(){
		boolean b1 = userService.hasMatchUser("admin", "121212");
		boolean b2 = userService.hasMatchUser("admin", "chenjiquan");
		
		assertTrue(b1);
		assertTrue(b2);
	}
	
	@Test
	public void findUserByUserName(){
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}
	
	@Test
	public void testAddLoginLog() {
		User user = userService.findUserByUserName("admin");
		user.setUserId(1);
		user.setUserName("admin");
		user.setLastIp("192.168.12.7");
		user.setLastVisit(new Date());
		userService.loginSuccess(user);
	}
}
