package com.spring.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

public class UserSErviceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService)container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPw("test123");
		
		//System.out.println("vo:"+vo);
		
		UserVO user = userService.getUser(vo);
		System.out.println(user);
		if(user != null) {
			System.out.println(user.getName()+"님 환영합니다");
		}else {
			System.out.println("로그인 실패");
		}
		
		container.close();
		
		
	}

}
