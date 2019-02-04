package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.spring.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointcut() {
	}
	
	@AfterReturning(pointcut="getPointcut()", returning="returnObj")
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
