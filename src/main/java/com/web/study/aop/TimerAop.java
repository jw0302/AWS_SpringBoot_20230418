package com.web.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TimerAop {
	
//	private final Logger logger = LogManager.getLogger(TimerAop.class);			// @Slf4j import하면 이 코드 안써도 된다.
	
	// PoinCut 표현식 - execution : Advice를 적용할 메서드를 명시할 때 사용합니다. (밑의 형식으로 사용(적용할 메서드 주소)) - / * : 모든 이라는 뜻
	// 접근지정자 public 은 생략 가능! (기본값임)
	@Pointcut("execution(* com.web.study..*.*(..))")
	private void pointCut() {}
	
	@Pointcut("@annotation(com.web.study.aop.annotation.TimerAspect)")
	private void annotationPointCut() {}

	@Around("annotationPointCut()&&pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		StopWatch stopWatch = new StopWatch();			// StopWatch (.start/.stop) - 메소드 실행 시간 확인 -
		stopWatch.start();
		
		// 전처리
		Object logic = joinPoint.proceed();			// proceed = 메소드 호출 -> {호출 되면 메소드가 실행된다.}
		// 후처리
		
		stopWatch.stop();
		log.info("[ Time ] >>> {}.{}: {}초", 
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(),
				stopWatch.getTotalTimeSeconds());

		return logic;
	}
}
