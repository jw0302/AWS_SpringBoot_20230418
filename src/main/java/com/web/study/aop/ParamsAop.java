package com.web.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ParamsAop {

	@Pointcut("@annotation(com.web.study.aop.annotation.ParamsAspect)")
	private void pointCut() {}
	
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		StringBuilder builder = new StringBuilder();
		
		// parameterName 가져오는 법 CodeSignature로 다운캐스팅 해줘야 함
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		String[] parameterNames = codeSignature.getParameterNames();
		Object[] args = joinPoint.getArgs();
		
		// for문도 기본 문법 써야함
		for(int i = 0; i < parameterNames.length; i++) {
			if(i != 0) {
				builder.append(", ");
			}
			builder.append(parameterNames[i] + ": " + args[i]);
		}
		
		
		log.info("[ Params ] >>> {}", builder.toString());
		
		return joinPoint.proceed();			// return joinPoint.procced를 넣으면 전처리만 하는거고 전/후 처리 모두 하려면 따로 빼서 올려나야 한다.
	}
}
