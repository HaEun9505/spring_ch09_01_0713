package com.haeun.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//공통 기능 클래스
public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "가 시작되었습니다.");
		
		long st = System.currentTimeMillis();	//현재 시간
		try {
			Object obj = joinpoint.proceed();	//joinpoint (메소드)실행
			return obj;	//object로 반환
		}finally {
			long et = System.currentTimeMillis();	//경과 시간
			System.out.println(signatureStr + "가 종료되었습니다.");
			System.out.println(signatureStr + "경과시간 : " + (et-st));
		}
	}
	//loggerAop 메소드 실행전에 먼저 실행
	public void beforeAdvice(JoinPoint joinpoint) {	
		System.out.println("beforeAdvice 실행!");
	}
	//메소드 실행중 exception 이 발생하여도 advice실행
	public void afterAdvice(JoinPoint joinpoint) {	
		System.out.println("afterAdvice 실행!");
	}
	//정상적으로 메소드 실행 후에 advice실행
	public void afterReturnAdvice(JoinPoint joinpoint) {	
		System.out.println("afterReturnAdvice 실행!");
	}
	// 메소드 실행중 exception 발생시 advice실행
	public void afterThrowingAdvice(JoinPoint joinpoint) {	
		System.out.println("afterThrowingAdvice 실행!");
	}
}
