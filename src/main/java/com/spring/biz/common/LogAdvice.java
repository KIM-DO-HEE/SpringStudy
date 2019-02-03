 package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp)
	{
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[���� ó��]"+method+"() �޼ҵ� ARGS ����:"+args[0].toString());
		//System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ����");
	}
}
