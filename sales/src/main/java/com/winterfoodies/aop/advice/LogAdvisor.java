package com.winterfoodies.aop.advice;

import com.winterfoodies.dto.Sales;
import com.winterfoodies.interceptor.LogComponent;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//4.2023.03.05 요 파일을 작성하시오.
@Aspect
@Component
@RequiredArgsConstructor
public class LogAdvisor {
    private final LogComponent logComponent;
   @Around("@annotation(com.winterfoodies.aop.target.SalesLogTarget)")
    public Object aroundSalesTransaction(ProceedingJoinPoint point) throws Throwable {
       Sales salesArg = (Sales)point.getArgs()[0];
       logComponent.logForSales(salesArg);
       return point.proceed();
   }
}
