package com.ssafy.aop.step01.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class PerformanceTraceAdvice {

	public void log() {
		System.out.println("공통 긴으 메서드 - 메서드 실행 전 호출됨..");
	}
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String signature = joinPoint.getSignature().toShortString();
//		System.out.println("PerformanceTraceAdvice : " + signature);
		long start = System.currentTimeMillis();
		// Before
		try {
			Object result = joinPoint.proceed();	// around라 핵심 기능 호출해야함!(around만 있음!)
			// After-returning
			return result;
//		} catch(Exception e){
//			// After-throwing
		}finally {
			// After
			long finish = System.currentTimeMillis();
			System.out.println("PerformanceTraceAdvice : " + signature + " 실행 시간 - " + (finish - start) + "ms");
		}
		
//		// 위, 아래 둘다 가능!(아래는 스프링에서 주는거!)
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//		
//		Object result = joinPoint.proceed();
//
//		stopWatch.stop();
//		System.out.println("PerformanceTraceAdvice : " + signature + " 실행 시간 - " + stopWatch.getTotalTimeMillis());
//		
//		return result;
	}

}
