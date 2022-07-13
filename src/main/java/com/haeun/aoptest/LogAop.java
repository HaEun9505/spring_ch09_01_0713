package com.haeun.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//���� ��� Ŭ����
public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "�� ���۵Ǿ����ϴ�.");
		
		long st = System.currentTimeMillis();	//���� �ð�
		try {
			Object obj = joinpoint.proceed();	//joinpoint (�޼ҵ�)����
			return obj;	//object�� ��ȯ
		}finally {
			long et = System.currentTimeMillis();	//��� �ð�
			System.out.println(signatureStr + "�� ����Ǿ����ϴ�.");
			System.out.println(signatureStr + "����ð� : " + (et-st));
		}
	}
	//loggerAop �޼ҵ� �������� ���� ����
	public void beforeAdvice(JoinPoint joinpoint) {	
		System.out.println("beforeAdvice ����!");
	}
	//�޼ҵ� ������ exception �� �߻��Ͽ��� advice����
	public void afterAdvice(JoinPoint joinpoint) {	
		System.out.println("afterAdvice ����!");
	}
	//���������� �޼ҵ� ���� �Ŀ� advice����
	public void afterReturnAdvice(JoinPoint joinpoint) {	
		System.out.println("afterReturnAdvice ����!");
	}
	// �޼ҵ� ������ exception �߻��� advice����
	public void afterThrowingAdvice(JoinPoint joinpoint) {	
		System.out.println("afterThrowingAdvice ����!");
	}
}
