 package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect = Pointcut + Advice
public class LogAdvice {
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* com.spring.biz..*Impl.*get(..))")
	public void getPointcut() {
		
	}
	
	@Before("allPointcut()")
	public void printLog()
	{
//		String method = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
		
		//System.out.println("[���� ó��]"+method+"() �޼ҵ� ARGS ����:"+args[0].toString());
		System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ����");
	}
}
