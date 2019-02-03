package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

import com.spring.biz.user.UserVO;

public class AfterReturningAdvice {
	
	public void afterLog(JoinPoint jp, Object returnObj) {
		//System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ����");
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName()+"�α���(Admin)");
			}
		}
		
		System.out.println("[���� ó��]" + method +"()�޼ҵ� ���� ��:"+returnObj.toString()); 
		
	}
}
