package com.haeun.aoptest;

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
}
